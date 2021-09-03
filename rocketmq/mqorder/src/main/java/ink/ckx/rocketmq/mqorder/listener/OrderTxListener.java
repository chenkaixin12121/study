package ink.ckx.rocketmq.mqorder.listener;

import ink.ckx.rocketmq.mqorder.domain.Order;
import ink.ckx.rocketmq.mqorder.domain.TransactionLog;
import ink.ckx.rocketmq.mqorder.repository.OrderRepository;
import ink.ckx.rocketmq.mqorder.repository.TransactionLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenkaixin
 * @description
 * @since 2021/9/1
 */
@Slf4j
@Component
@RocketMQTransactionListener
@RequiredArgsConstructor
public class OrderTxListener implements RocketMQLocalTransactionListener {

    private final OrderRepository orderRepository;

    private final TransactionLogRepository transactionLogRepository;

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        log.info("收到创建订单事务消息，msg：{}，arg：{}", msg, arg);
        Order order = (Order) arg;

        MessageHeaders headers = msg.getHeaders();
        String transactionId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);
        try {
            TransactionLog transactionLog = TransactionLog.builder()
                    .transactionId(transactionId)
                    .log("创建订单事务消息")
                    .build();
            this.saveOrder(order, transactionLog);
            log.info("创建订单事务提交：{}", transactionId);
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            log.info("创建订单事务回滚：{}", transactionId);
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        MessageHeaders headers = msg.getHeaders();
        String transactionId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);

        int resultCount = transactionLogRepository.countByTransactionId(transactionId);
        if (resultCount == 0) {
            log.info("创建订单回查事务回滚：{}", transactionId);
            return RocketMQLocalTransactionState.ROLLBACK;
        }
        log.info("创建订单回查事务提交：{}", transactionId);
        return RocketMQLocalTransactionState.COMMIT;
    }

    @Transactional
    public void saveOrder(Order order, TransactionLog transactionLog) {
        orderRepository.save(order);
        transactionLogRepository.save(transactionLog);
    }
}