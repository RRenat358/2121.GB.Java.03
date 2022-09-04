import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorApp_2 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService poolThread = Executors.newFixedThreadPool(4, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                System.out.println("=== New Thread ===");
                return new Thread(r);
            }
        });

        poolThread.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(1);
            }
        });
        poolThread.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(2);
        });
        poolThread.execute(() -> {
//            Thread.currentThread().setDaemon(true);
            System.out.println(Thread.currentThread().getName());
            System.out.println(3);
        });
        poolThread.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(4);
        });
        poolThread.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(11);
        });
        poolThread.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(12);
        });
        poolThread.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(13);
        });

        poolThread.awaitTermination(5, TimeUnit.SECONDS);

//        poolThread.shutdown();
        poolThread.shutdownNow();


    }


}
