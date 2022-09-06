import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//public class Car implements Runnable {
public class Car implements Runnable {
    private static int CARS_COUNT;

//    ExecutorService executorService = Executors.newCachedThreadPool();


    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

//    private MainClass mainClass;

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
        this.name = "Машина # " + CARS_COUNT;
        System.out.println(this.name + " готовится");

        try {
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
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
//        System.out.println(this.name + " готов");
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

/*
            try {
                System.out.println(cyclicBarrier.getNumberWaiting());
                System.out.println(cyclicBarrier.getParties());

                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
*/




/*
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
*/

/*
        executorService.execute(()-> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
*/


    }


}