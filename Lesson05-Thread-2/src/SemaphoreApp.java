import java.util.concurrent.Semaphore;

public class SemaphoreApp {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            final int w = i + 1;
            new Thread(() -> {
                try {
                    System.out.println("Поток " + w + " перед семофором [X]");
                    System.out.println(semaphore.getQueueLength());
                    semaphore.acquire();
                    System.out.println("Поток " + w + " получил доступ к ресурсу -->> ");
                    Thread.sleep(1000);
                } catch (Exception exception) {

                } finally {
                    System.out.println("Поток " + w + " --> отпустил ресурс");
                    semaphore.release();
                }

            }).start();
        }

    }


}
