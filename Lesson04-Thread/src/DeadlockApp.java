


public class DeadlockApp {

    public static void main(String[] args) {

    }

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    private static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + "locked lock1");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " waiting for lock2");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " locked lock2");
                }
            }
        }
    }

    private static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "locked lock2");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " waiting for lock1");
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " locked lock1");
                }
            }
        }
    }


}
