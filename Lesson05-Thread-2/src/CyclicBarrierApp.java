import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApp {

    private static Random random = new Random();

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        for (int i = 0; i < 5; i++) {
            int w = i + 1;

            new Thread(() -> {
                try {
                    //task

                    System.out.println("Поток " + w + " готовится [X]");
                    Thread.sleep(random.nextInt(5) * 1000);
                    System.out.println("Поток " + w + " готов !");
                    cyclicBarrier.await();

                    System.out.println("Поток " + w + " поехал -->>");
                    Thread.sleep(random.nextInt(5) * 1000);
                    System.out.println("Поток " + w + "--> доехал");
                    cyclicBarrier.await();

                } catch (Exception e) {
                    //ignore
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
