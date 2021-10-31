package ink.ckx.consurrency.publish;

import ink.ckx.consurrency.annoations.NotRecommend;
import ink.ckx.consurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/31
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private final int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    public static void main(String[] args) {
        new Escape();
    }

    private class InnerClass {

        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }
}
