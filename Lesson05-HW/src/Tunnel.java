import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {


    private int length = 0;
    private int throughput = 0;


    public Tunnel(int length, int throughput) {
        this.length = length;
        this.throughput = throughput;
        this.description = "Тоннель " + length + " метров";
    }

    private final Semaphore semaphore = new Semaphore(/*throughput*/2);

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу(ждёт): " + description);
            semaphore.acquire();

            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(c.getName() + " закончил этап: " + description);
            semaphore.release();
        }

    }


}