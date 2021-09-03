package ink.ckx.rocketmq.mqstorage.listener;

import cn.hutool.json.JSONUtil;
import ink.ckx.rocketmq.mqstorage.domain.Storage;
import ink.ckx.rocketmq.mqstorage.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author chenkaixin
 * @description
 * @since 2021/9/3
 */
@Slf4j
@RequiredArgsConstructor
@RocketMQMessageListener(topic = "txTopic", selectorExpression = "txTag", consumerGroup = "tx-consumer-group")
@Component
public class DeductionStorageListener implements RocketMQListener<MessageExt> {

    private final StorageRepository storageRepository;

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public void onMessage(MessageExt message) {
        String msg = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("收到扣减库存消息：{}", msg);

        String msgId = message.getMsgId();
        if (stringRedisTemplate.opsForSet().isMember("msgId", msgId)) {
            log.info("msgId：{}，消息不能重复消费", msgId);
            return;
        }
        try {
            Storage storage = JSONUtil.toBean(msg, Storage.class);
//            int i = 1/0;

            Storage selectStorage = storageRepository.findByCommodityCode(storage.getCommodityCode());
            selectStorage.setCount(selectStorage.getCount() - storage.getCount());
            storageRepository.save(selectStorage);

            stringRedisTemplate.opsForSet().add("msgId", msgId);
        } catch (Exception e) {
            if (message.getReconsumeTimes() < 3) {
                log.info("扣减库存消息消费失败，进行第 {} 次重试", message.getReconsumeTimes() + 1);
                throw new RuntimeException(e);
            } else {
                log.info("扣减库存消息已达最大重试次数");
                // TODO 失败消息入库
            }
        }
    }
}