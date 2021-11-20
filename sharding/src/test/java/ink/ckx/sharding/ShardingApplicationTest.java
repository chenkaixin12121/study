package ink.ckx.sharding;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import ink.ckx.sharding.entity.TOrder;
import ink.ckx.sharding.entity.TOrderItem;
import ink.ckx.sharding.mapper.TOrderItemMapper;
import ink.ckx.sharding.mapper.TOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@SpringBootTest
class ShardingApplicationTest {

    @Autowired
    private TOrderMapper tOrderMapper;

    @Autowired
    private TOrderItemMapper tOrderItemMapper;

    @Test
    void save() {
        for (long i = 0; i < 10; i++) {
//            HintManager.clear();
//            HintManager hintManager = HintManager.getInstance();
//            // 指定数据库
//            hintManager.addDatabaseShardingValue("t_order", 0);
//            // 指定数据库表
//            hintManager.addTableShardingValue("t_order" , 0);
//            // 在读写分离数据库中，Hint 可以强制读主库
//            // hintManager.setMasterRouteOnly();

            TOrder tOrder = new TOrder();
            tOrder.setOrderNo("订单" + i);
            tOrder.setAmt(new BigDecimal("16.66"));
            tOrder.setUserId(i);

            tOrderMapper.insert(tOrder);

            TOrderItem tOrderItem = new TOrderItem();
            tOrderItem.setOrderId(tOrder.getOrderId());
            tOrderItem.setItemName("商品" + i);
            tOrderItem.setPrice(new BigDecimal("16.66"));
            tOrderItem.setQty(1);

            tOrderItemMapper.insert(tOrderItem);
        }
    }

    @Test
    void findById() {
        TOrder tOrder = tOrderMapper.selectById(331L);
        log.info("订单：{}", tOrder);

        LambdaQueryWrapper<TOrderItem> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(TOrderItem::getOrderId, tOrder.getOrderId());
        List<TOrderItem> tOrderItemList = tOrderItemMapper.selectList(queryWrapper);
        log.info("订单商品：{}", tOrderItemList);
    }
}