package ink.ckx.consurrency.syncContainer;

import ink.ckx.consurrency.annoations.NotThreadSafe;

import java.util.Vector;

/**
 * @author chenkaixin
 * @description
 * @since 2021/10/31
 */
@NotThreadSafe
public class VectorExample2 {

    private static final Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            }).start();
            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.get(i);
                }
            }).start();
        }
    }
}