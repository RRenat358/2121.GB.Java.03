import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockApp {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    //критическая секция
                } catch (Exception e) {

                }finally {
                    lock.unlock();
                }
            }
        }).start();
    }

}
