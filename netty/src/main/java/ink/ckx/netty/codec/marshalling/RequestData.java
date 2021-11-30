package ink.ckx.netty.codec.marshalling;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenkaixin
 * @description
 * @since 2021/11/30
 */
@Data
public class RequestData implements Serializable {

    private static final long serialVersionUID = 3614087961303385966L;

    private String id;

    private String name;

    private String requestMessage;

    private byte[] attachment;
}
