

public class ThreadABC {

    private static final Object objSync = new Object();
    private static String A = " A ";
    private static String B = " B ";
    private static String C = " C ";
    private volatile static String abc = "";


    public static void main(String[] args) {

        //======================================================================
/*        Thread threadA = new Thread(() -> {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();*/

        Thread threadA = new Thread(() -> {
            synchronized (objSync) {
                try {
                    for (int i = 0; i < 5; ) {
                        if (abc == A) {
                            objSync.wait();
                        }
                        if (abc == C || abc == "") {
                            System.out.print(A);
                            i++;
                            abc = A;
                            objSync.notifyAll();
                        }
                    }
                } catch (Exception e) {
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
/*
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadB.start();
*/

        Thread threadB = new Thread(() -> {
            synchronized (objSync) {
                try {
                    for (int i = 0; i < 5; ) {
                        if (abc == B) {
                            objSync.wait();
                        }
                        if (abc == A) {
                            System.out.print(B);
                            i++;
                            abc = B;
                            objSync.notifyAll();
                        }
                    }
                } catch (Exception e) {
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
/*
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadC.start();
*/

        Thread threadC = new Thread(() -> {
            synchronized (objSync) {
                try {
                    for (int i = 0; i < 5; ) {
                        if (abc == C) {
                            objSync.wait();
                        }
                        if (abc == B) {
                            System.out.print(C);
                            i++;
                            abc = C;
                            objSync.notifyAll();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadC.start();









    }

}
