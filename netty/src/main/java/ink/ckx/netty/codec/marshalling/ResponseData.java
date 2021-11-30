package ink.ckx.netty.codec.marshalling;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenkaixin
 * @description
 * @since 2021/11/30
 */
@Data
public class ResponseData implements Serializable {

    private static final long serialVersionUID = 2475396493406997733L;

    private String id;

    private String name;

    private String responseMessage;
}
