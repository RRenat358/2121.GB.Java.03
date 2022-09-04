import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerApp {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();


        new Thread(() -> {
            atomicInteger.incrementAndGet();
            if (atomicInteger.get() == 1) {
                System.out.println("1 thread win");
            }
        }).start();

        new Thread(() -> {
            atomicInteger.incrementAndGet();
            if (atomicInteger.get() == 1) {
                System.out.println("2 thread win");
            }
        }).start();

    }

}
