import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockApp {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    //критическая секция

                    if (!lock.tryLock(10, TimeUnit.SECONDS)) {
                        System.out.println("Не удалось захватить блокировку");
                    }
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }).start();

        //v2
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.readLock();
    }


}
