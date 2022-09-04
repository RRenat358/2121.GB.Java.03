import java.util.concurrent.*;

public class FutureApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        int[] source = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] res1 = new int[4];
        int[] res2 = new int[4];

        System.arraycopy(source, 0, res1, 0, res1.length);
        System.arraycopy(source, 4, res2, 0, res2.length);


        Callable<Integer> callable1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res0 = 0;
                for (int i = 0; i < res1.length; i++) {
                    res0 += res1[i];
                }
                Thread.sleep(3000);
                return res0;
            }
        };

        Callable<Integer> callable2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res0 = 0;
                for (int i = 0; i < res2.length; i++) {
                    res0 += res2[i];
                }
                Thread.sleep(3000);
                return res0;
            }
        };

        Future<Integer> future1 = executorService.submit(callable1);
        Future<Integer> future2 = executorService.submit(callable2);

        new Thread(() -> {
            while (!future1.isDone()) {
                System.out.println("Future 1 still working");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            while (!future2.isDone()) {
                System.out.println("Future 2 still working");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        System.out.println("future1 = " + future1.get());
        System.out.println("future2 = " + future2.get());
        System.out.println("Sum f1 + f2 = " + future1.get() + future2.get());

        executorService.shutdown();


    }

}
