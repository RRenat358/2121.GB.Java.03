public class VolatileApp {


    private static boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (isRunning) {
                System.out.println("Still alive");
                try {
                    Thread.sleep(500);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();


        Thread.sleep(2000);
        isRunning = false;
        System.out.println("Stop while in thread");

    }


}
