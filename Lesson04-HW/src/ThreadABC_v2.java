
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadABC_v2 {


    private static String A = " A ";
    private static String B = " B ";
    private static String C = " C ";
    private volatile static String abcNext = "";

//    private static final Object objSync = new Object();


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();


        Thread threadA = new Thread(() -> {
//            synchronized (objSync) {
            lock.lock();
            try {
                for (int iA = 0; iA < 5; ) {
                    if (abcNext == A || abcNext == "") {
                        System.out.print(A);
                        iA++;
                        abcNext = B;
//                            objSync.notifyAll();
                        condition.signalAll();
                    }
                    if (iA == 5) {
                        Thread.currentThread().interrupt();
                    }
//                        objSync.wait();
                    condition.await();
                }
            } catch (Exception e) {
                //ignore
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
//            }
        });
        threadA.start();


        Thread threadB = new Thread(() -> {
//            synchronized (objSync) {
            lock.lock();
            try {
                for (int iB = 0; iB < 5; ) {
                    if (abcNext == B) {
                        System.out.print(B);
                        iB++;
                        abcNext = C;
//                            objSync.notifyAll();
                        condition.signalAll();
                    }
                    if (iB == 5) {
                        Thread.currentThread().interrupt();
                    }
//                        objSync.wait();
                    condition.await();
                }
            } catch (Exception e) {
                //ignore
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
//            }
        });
        threadB.start();


        Thread threadC = new Thread(() -> {
//            synchronized (objSync) {
            lock.lock();
            try {
                for (int iC = 0; iC < 5; ) {
                    if (abcNext == C) {
                        System.out.println(C);
                        iC++;
                        abcNext = A;
//                            objSync.notifyAll();
                        condition.signalAll();
                    }
                    if (iC == 5) {
                        Thread.currentThread().interrupt();
                    }
//                        objSync.wait();
                    condition.await();
                }
            } catch (Exception e) {
                //ignore
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
//            }
        });
        threadC.start();


    }


}
