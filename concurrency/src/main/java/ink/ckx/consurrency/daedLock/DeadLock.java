package ink.ckx.consurrency.daedLock;

public class DeadLock {

    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("线程%s持有资源1想要获取到资源2", Thread.currentThread().getName()));
                synchronized (o2) {
                    System.out.println(String.format("线程%s获取到了资源2", Thread.currentThread().getName()));
                }
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o2) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("线程%s持有资源2想要获取到资源1", Thread.currentThread().getName()));
                synchronized (o1) {
                    System.out.println(String.format("线程%s获取到了资源1", Thread.currentThread().getName()));
                }
            }
        }, "t2").start();
    }
}