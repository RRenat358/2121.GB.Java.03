

public class ThreadABC {

    private static final Object objSync = new Object();
    private static String A = " A ";
    private static String B = " B ";
    private static String C = " C ";
    private static String abc = "";


    public static void main(String[] args) {

        //======================================================================
        Thread threadA = new Thread(() -> {
            synchronized (objSync) {
                try {
                    for (int i = 0; i < 5; i++) {
                        if (abc != A) {
                            System.out.print(A);
                            abc = A;
                        } else {
                            objSync.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        threadA.start();


        //======================================================================
        Thread threadB = new Thread(() -> {
            synchronized (objSync) {
                System.out.print(B);

            }
        });
        threadB.start();


        //======================================================================
        Thread threadC = new Thread(() -> {
            synchronized (objSync) {
                System.out.print(C);

            }
        });
        threadC.start();


    }

}
