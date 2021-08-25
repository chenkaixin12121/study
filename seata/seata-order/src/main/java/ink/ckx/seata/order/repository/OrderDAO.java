package ink.ckx.seata.order.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ink.ckx.seata.order.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDAO extends BaseMapper<Order> {
}
