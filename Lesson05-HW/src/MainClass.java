import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;


public class MainClass {

    public static final int CARS_COUNT = 4;


    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        ExecutorService executorService = Executors.newCachedThreadPool();

//        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
//        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(CARS_COUNT);
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        CountDownLatch countDownLatch2 = new CountDownLatch(CARS_COUNT);

        List<String> finishList = Collections.synchronizedList(new ArrayList<>());

        Car[] cars = new Car[CARS_COUNT];

        Race race = new Race(
                new Road(60),
                new Tunnel(80, Math.round(CARS_COUNT/2)),
                new Road(40)
        );

        //==================================================
        System.out.println("\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!! \n");

        for (int i = 0; i < cars.length; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    cars[finalI] = new Car(race, 20 + (int) (Math.random() * 10));
//                    cyclicBarrier.await();
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
//        cyclicBarrier.await();
        countDownLatch.await();

        //==================================================
        System.out.println("\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!! \n");

        for (int i = 0; i < cars.length; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    cars[finalI].run();
                    finishList.add(cars[finalI].getName());
//                    cyclicBarrier.await();
                    countDownLatch2.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
//        cyclicBarrier.await();
        countDownLatch2.await();

        //==================================================
        // Финиш
        executorService.shutdown();

        System.out.printf("\n%s  -> WIN <-  \n", finishList.get(0));

        System.out.println("\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!! \n");

    }

}