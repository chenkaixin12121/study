package ink.ckx.consurrency.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenkaixin
 * @description
 * @since 2021/12/18
 */
public class CompletableFutureExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "------test1");
        });
        System.out.println(future1.get());

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "------test2");
        }, executorService);
        System.out.println(future2.get());

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "------test3");
            return "test3";
        });
        System.out.println(future3.get());

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "------test4");
            return "test4";
        }, executorService);
        System.out.println(future4.get());

        executorService.shutdown();
    }
}