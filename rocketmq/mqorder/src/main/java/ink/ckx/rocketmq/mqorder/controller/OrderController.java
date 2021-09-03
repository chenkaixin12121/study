package ink.ckx.rocketmq.mqorder.controller;

import ink.ckx.rocketmq.mqorder.domain.Order;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author chenkaixin
 * @description
 * @since 2021/9/1
 */
@RequiredArgsConstructor
@RequestMapping("/order")
@RestController
public class OrderController {

    private final RocketMQTemplate rocketMQTemplate;

    @PostMapping("/save")
    public String saveOrder() {
        Order order = Order.builder()
                .userId("10")
                .commodityCode("product-1")
                .count(1)
                .money(60)
                .build();
        Map<String, Object> map = new HashMap<>();
        map.put("commodityCode", order.getCommodityCode());
        map.put("count", order.getCount());
        TransactionSendResult transactionSendResult = rocketMQTemplate.sendMessageInTransaction(
                "txTopic:txTag",
                MessageBuilder.withPayload(map)
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, UUID.randomUUID().toString())
                        .build(),
                order);
        return "发送事务消息成功：" + transactionSendResult;
    }
}