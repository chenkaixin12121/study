package ink.ckx.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TOrder {

    @TableId
    private Long orderId;

    private String orderNo;

    private BigDecimal amt;

    private Long userId;
}