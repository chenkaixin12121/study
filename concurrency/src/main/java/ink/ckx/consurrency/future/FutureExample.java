package ink.ckx.consurrency.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author chenkaixin
 * @description
 * @since 2021/11/1
 */
@Slf4j
public class FutureExample {

    public static void main(String[] args) throws Exception {
        Future<String> future = Executors.newCachedThreadPool().submit(() -> {
            log.info("do something in callable");
            Thread.sleep(10000);
            return "Done";
        });
        log.info("do something in main");
        // get 会阻塞，尽量不使用，使用带超时时间的或者轮询
        String result = future.get();
        log.info("result：{}", result);
    }
}