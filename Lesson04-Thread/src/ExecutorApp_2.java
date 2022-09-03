import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorApp_2 {

    public static void main(String[] args) {

        ExecutorService poolThread = Executors.newFixedThreadPool(4, new ThreadFactory(){
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
            System.out.println(Thread.currentThread().getName());
            System.out.println(3);
        });
        poolThread.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(4);
        });
        poolThread.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(5);
        });
        poolThread.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(6);
        });
        poolThread.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(7);
        });

        poolThread.shutdown();


    }


}
