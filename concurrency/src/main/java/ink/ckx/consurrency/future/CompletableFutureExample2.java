package ink.ckx.consurrency.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author chenkaixin
 * @description
 * @since 2021/12/18
 */
public class CompletableFutureExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "test3";
        }).thenApply(f -> f + "4")
                .whenComplete((v, e) -> {
                    if (e == null) {
                        System.out.println("------result:" + v);
                    }
                }).exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                })/*.join()*/;
        System.out.println("------main over");
//        System.out.println(future.get());
//        System.out.println(future.getNow("getNow"));
//        System.out.println(future.complete("complete") + " " + future.get());

        try {
            // 主线程不要立刻结束，否则 CompletableFuture 默认使用的线程池会立刻关闭
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}