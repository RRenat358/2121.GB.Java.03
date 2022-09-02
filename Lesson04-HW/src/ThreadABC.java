

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
                        if (abcNext == A || abcNext == "") {
                            System.out.print(A);
                            iA++;
                            abcNext = B;
                            objSync.notifyAll();
                        }
                        if (iA == 5) {
                            Thread.currentThread().interrupt();
                        }
                        if (abcNext != A) {
                            objSync.wait();
                        }
                    }
                } catch (Exception e) {
                    //Exception ignore
                    Thread.currentThread().interrupt();
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
                        if (iB == 5) {
                            Thread.currentThread().interrupt();
                        }
                        if (abcNext != B) {
                            objSync.wait();
                        }

                    }
                } catch (Exception e) {
                    //Exception ignore
                    Thread.currentThread().interrupt();
                }
            }
        });
        threadB.start();

        //======================================================================
        Thread threadC = new Thread(() -> {
            synchronized (objSync) {
                try {
                    for (int iC = 0; iC < 5; ) {
                        if (abcNext == C) {
                            System.out.println(C);
                            iC++;
                            abcNext = A;
                            objSync.notifyAll();
                        }
                        if (iC == 5) {
                            Thread.currentThread().interrupt();
                        }
                        if (abcNext != C) {
                            objSync.wait();
                        }
                    }
                } catch (Exception e) {
                    //Exception ignore
                    Thread.currentThread().interrupt();
                }
            }
        });
        threadC.start();



    }

}
