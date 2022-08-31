
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorApp {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();


        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));

        Future<?> future = executorService.submit(() -> System.out.println("future"));





    }

    private static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "String from Callable";
        }



    }



}
