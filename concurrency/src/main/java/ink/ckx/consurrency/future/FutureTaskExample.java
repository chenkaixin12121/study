package ink.ckx.consurrency.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;

/**
 * @author chenkaixin
 * @description
 * @since 2021/11/1
 */
@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("do something in callable");
            Thread.sleep(10000);
            return "Done";
        });
        new Thread(futureTask).start();
        log.info("do something in main");
        String result = futureTask.get();
        log.info("result：{}", result);
    }
}