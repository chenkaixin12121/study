package ink.ckx.sharding.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TOrderItem {

    private Long itemId;

    private Long orderId;

    private String itemName;

    private BigDecimal price;

    private Integer qty;
}