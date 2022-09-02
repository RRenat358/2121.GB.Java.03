import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadABC_v2 {


    private static final Object objSync = new Object();
    private static String A = " A ";
    private static String B = " B ";
    private static String C = " C ";
    private volatile static String abcNext = "";


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();


        Thread threadA = new Thread(() -> {
//            synchronized (objSync) {
                try {
                    lock.lock();
                    for (int iA = 0; iA < 5; ) {
                        if (abcNext == A || abcNext == "") {
                            System.out.print(A);
                            iA++;
                            abcNext = B;
//                            objSync.notifyAll();
                            lock.unlock();
                        }
                        if (iA == 5) {
                            Thread.currentThread().interrupt();
                        }
//                        objSync.wait();
//                        lock.lock();
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
                try {
                    lock.lock();
                    for (int iB = 0; iB < 5; ) {
                        if (abcNext == B) {
                            System.out.print(B);
                            iB++;
                            abcNext = C;
//                            objSync.notifyAll();
                            lock.unlock();
                        }
                        if (iB == 5) {
                            Thread.currentThread().interrupt();
                        }
//                        objSync.wait();
//                        lock.lock();
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
                try {
                    lock.lock();
                    for (int iC = 0; iC < 5; ) {
                        if (abcNext == C) {
                            System.out.println(C);
                            iC++;
                            abcNext = A;
//                            objSync.notifyAll();
                            lock.unlock();
                        }
                        if (iC == 5) {
                            Thread.currentThread().interrupt();
                        }
//                        objSync.wait();
//                        lock.lock();
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
