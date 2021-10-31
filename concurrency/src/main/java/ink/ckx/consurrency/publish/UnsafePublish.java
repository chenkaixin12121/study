package ink.ckx.consurrency.publish;

import ink.ckx.consurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/31
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private final String[] states = {"a", "b", "c"};

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }

    public String[] getStates() {
        return states;
    }
}

