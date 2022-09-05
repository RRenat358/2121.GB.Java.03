import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//public class Car implements Runnable {
public class Car implements Runnable {
    private static int CARS_COUNT;

    ExecutorService executorService = Executors.newCachedThreadPool();


    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Машина # 00" + CARS_COUNT;
    }

//    CyclicBarrier cyclicBarrier = new CyclicBarrier(4);//todo
/*
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }
*/

    @Override
    public void run() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }


/*
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
*/

        for (int i = 0; i < race.getStages().size(); i++) {

            int finalI = i;
            executorService.execute(()->{
                if (finalI == 0) {
                    try {

                        cyclicBarrier.await();
//                        race.getStages().get(finalI).go(this);
//                    continue;
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
            race.getStages().get(finalI).go(this);
//            if (finalI > 0){
//                race.getStages().get(finalI).go(this);
//            }




        }


/*
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
*/




    }




}