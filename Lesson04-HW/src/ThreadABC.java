

public class ThreadABC {

    private static final Object objSync = new Object();
    private static String A = " A ";
    private static String B = " B ";
    private static String C = " C ";
    private volatile static String abcNext = "";


    public static void main(String[] args) {

        //======================================================================
        Thread threadA = new Thread(() -> {
            synchronized (objSync) {
                try {
                    for (int iA = 0; iA < 5; ) {
                        if (abcNext == "" || abcNext == A ) {
                            System.out.print(A);
                            iA++;
                            abcNext = B;
                            objSync.notifyAll();
                        }
//                        while (abcNext != A) {
                            objSync.wait();
//                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();


        //======================================================================
        Thread threadB = new Thread(() -> {
            synchronized (objSync) {
                try {
                    for (int iB = 0; iB < 5; ) {
                        if (abcNext == B) {
                            System.out.print(B);
                            iB++;
                            abcNext = C;
                            objSync.notifyAll();
                        }
                        while (abcNext != B) {
                            objSync.wait();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadB.start();

        //======================================================================
        Thread threadC = new Thread(() -> {
            synchronized (objSync) {
                try {
                    for (int iC = 0; iC < 5; ) {
                        while (abcNext != C) {
                            objSync.wait();
                        }
                        if (abcNext == C) {
                            System.out.println(C);
                            iC++;
                            abcNext = A;
                            objSync.notifyAll();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadC.start();




/*
        threadA.start();
        threadB.start();
        threadC.start();
*/


    }

}
