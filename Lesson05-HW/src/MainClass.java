import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;


public class MainClass {

    public static final int CARS_COUNT = 4;


    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newFixedThreadPool(CARS_COUNT);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        CountDownLatch countDownLatch2 = new CountDownLatch(CARS_COUNT);

        List<String> listWin = Collections.synchronizedList(new ArrayList<>());

        Car[] cars = new Car[CARS_COUNT];

        Race race = new Race(new Road(60), new Tunnel(80, 2), new Road(40));


        //==================================================
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");


        for (int i = 0; i < cars.length; i++) {
//            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));

//            int finalI = i;
            Integer finalI = i;

            new Thread(() -> {
                try {
                    cars[finalI] = new Car(race, 20 + (int) (Math.random() * 10));
//                    cyclicBarrier.await();
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

/*
            executorService.execute(() -> {
                try {
                    cars[finalI] = new Car(race, 20 + (int) (Math.random() * 10));
                    cyclicBarrier.await();
//                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
*/



        }
//        cyclicBarrier.await();
        countDownLatch.await();



        //==================================================
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        for (int i2 = 0; i2 < cars.length; i2++) {
//            new Thread(cars[i]).start();

//            int finalI2 = i2;
            Integer finalI2 = i2;

            new Thread(() -> {
                try {
                    cars[finalI2].run();
//                    cyclicBarrier.await();
                    countDownLatch2.countDown();

                    listWin.add(cars[finalI2].getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();



/*
            executorService.execute(() -> {
                try {
                    cars[finalI2].run();
                    cyclicBarrier.await();
//                    countDownLatch.countDown();

                    listWin.add(cars[finalI2].getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
*/

        }

//        cyclicBarrier.await();
        countDownLatch2.await();


        System.out.println(listWin.get(0) + " > WIN < ");
//        cyclicBarrier.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

    }


}