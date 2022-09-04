import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApp_2 {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Все потоки достигли барьера");
            }
        });

        Thread t1 = new Thread(new Task(cyclicBarrier), "Thread 1");
        Thread t2 = new Thread(new Task(cyclicBarrier), "Thread 2");
        Thread t3 = new Thread(new Task(cyclicBarrier), "Thread 3");
        Thread t4 = new Thread(new Task(cyclicBarrier), "Thread 3");
        Thread t5 = new Thread(new Task(cyclicBarrier), "Thread 3");
        Thread t6 = new Thread(new Task(cyclicBarrier), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();


    }


    private static class Task implements Runnable{

        private CyclicBarrier cyclicBarrier2;

        public Task(CyclicBarrier cyclicBarrier2) {
            this.cyclicBarrier2 = cyclicBarrier2;
        }

        @Override
        public void run() {
            try {
                System.out.println(CyclicBarrierApp.class.getName() + " ждёт у шлагбаума");
                cyclicBarrier2.await();
                System.out.println(CyclicBarrierApp.class.getName() + " пересёк барьер");

            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }

    }




}
