import java.util.concurrent.CountDownLatch;

public class CountDownLatchApp_2 {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.printf("Поток %d начал работу \n", finalI);
                    try {
//                        Thread.sleep((int) Math.random() * 2000);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.printf("Поток %d подошёл к защёлке \n", finalI);
                    countDownLatch.countDown();
                    System.out.printf("Поток %d продолжил работу \n", finalI);
                }
            }).start();
        }
        countDownLatch.await();


    }


}
