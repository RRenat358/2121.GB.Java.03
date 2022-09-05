import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;


public class MainClass {

    public static final int CARS_COUNT = 4;


    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);

        List<String> listWin = Collections.synchronizedList(new ArrayList<>());



        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Car[] cars = new Car[CARS_COUNT];

        Race race = new Race(new Road(60), new Tunnel(80, 2), new Road(40));

        for (int i = 0; i < cars.length; i++) {
//            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));

            int finalI = i;


            executorService.execute(() -> {
                try {
                    cars[finalI] = new Car(race, 20 + (int) (Math.random() * 10));
                    cyclicBarrier.await();
//                        countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        cyclicBarrier.await();
//        countDownLatch.await();


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        for (int i = 0; i < cars.length; i++) {
//            new Thread(cars[i]).start();

            int finalI = i;

            executorService.execute(() -> {
                try {
                    cars[finalI].run();
                    cyclicBarrier.await();
//                    listWin.add(cars[finalI].getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }

        cyclicBarrier.await();


        System.out.println(listWin.get(0) + " > WIN < ");
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

    }


}