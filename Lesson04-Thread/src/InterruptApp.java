public class InterruptApp {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    System.out.println(i + 1);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();

                        Thread.currentThread().interrupt(); //Concurrency in practice
                    }
                }
            }
        });

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }
}
