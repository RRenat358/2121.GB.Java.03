

public class ThreadABC {

    private static final Object objSync = null;

    public static void main(String[] args) {

        //======================================================================
        Thread threadA = new Thread(() -> {
            synchronized (objSync) {
                System.out.println(" A ");

            }
        });
        threadA.start();


        //======================================================================
        Thread threadB = new Thread(() -> {
            synchronized (objSync) {
                System.out.println(" B ");

            }
        });
        threadB.start();


        //======================================================================
        Thread threadC = new Thread(() -> {
            synchronized (objSync) {
                System.out.println(" C ");

            }
        });
        threadC.start();


    }

}
