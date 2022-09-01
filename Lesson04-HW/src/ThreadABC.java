

public class ThreadABC {

    private static final Object objSync = new Object();
    private static String A = " A ";
    private static String B = " B ";
    private static String C = " C ";
    private volatile static String abc = "";


    public static void main(String[] args) {

        //======================================================================
        Thread threadA = new Thread(() -> {
            synchronized (objSync) {
                try {
                    for (int i = 0; i < 5; i++) {
                        if (abc == "" || abc == C) {
                            System.out.print(A);
                            abc = A;
                            objSync.notifyAll();
                        } else {
                            objSync.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();


        //======================================================================
/*        Thread threadB = new Thread(() -> {
            synchronized (objSync) {
                System.out.print(B);

            }
        });
        threadB.start();*/
        Thread threadB = new Thread(() -> {
            synchronized (objSync) {
                try {
                    for (int i = 0; i < 5; i++) {
                        if (abc == A) {
                            System.out.print(B);
                            abc = B;
                            objSync.notifyAll();
                        } else {
                            objSync.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadB.start();

        //======================================================================
/*
        Thread threadC = new Thread(() -> {
            synchronized (objSync) {
                System.out.print(C);

            }
        });
        threadC.start();
*/
        Thread threadC = new Thread(() -> {
            synchronized (objSync) {
                try {
                    for (int i = 0; i < 5; i++) {
                        if (abc == B) {
                            System.out.print(C);
                            abc = C;
                            objSync.notifyAll();
                        } else {
                            objSync.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadC.start();

    }

}
