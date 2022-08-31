




public class ThreadApp {

    public static void main(String[] args) {
        Runnable task = new MyRunnable();
        Thread thread = new Thread(task);
        Thread threadAnother = new Thread(task);
        thread.start();
        Thread thread2 = new MyTread();
        thread2.start();
        Thread thread3 = new Thread(() -> System.out.println("Do smth 2"));
        try {
            thread3.join(3000);
            //дождались
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyTread extends Thread {
        @Override
        public void run() {
            System.out.println("Do smth");
        }
    }



}
