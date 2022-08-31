
import java.util.concurrent.*;

public class ExecutorApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();


        //======================================================================
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

        //======================================================================
        Future<?> future = executorService.submit(() -> System.out.println("future"));


        //======================================================================
        Future<String> futur2 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "String from Callable -- 01";
            }
        });
        System.out.println(futur2.get());

        Future<String> futur3 = executorService.submit(new MyCallable());
        System.out.println(futur3.get());



        //======================================================================
        //Обязательно завершать
        executorService.shutdown();
//        executorService.shutdownNow(); //интреапт всем -- прямо сейчас!

    }

    private static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "String from Callable -- 02";
        }
    }



}
