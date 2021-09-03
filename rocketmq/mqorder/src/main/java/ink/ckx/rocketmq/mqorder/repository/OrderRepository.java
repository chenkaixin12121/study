package ink.ckx.rocketmq.mqorder.repository;

import ink.ckx.rocketmq.mqorder.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chenkaixin
 * @description
 * @since 2021/9/1
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
