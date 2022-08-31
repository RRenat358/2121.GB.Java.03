import java.util.concurrent.atomic.AtomicInteger;

public class CounterApp {



    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        DoubleCouter doubleCouter = new DoubleCouter();

        AtomicInteger atomicInteger = new AtomicInteger(0);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    atomicInteger.incrementAndGet();
                    counter.increment();
                    doubleCouter.incrementFirst();
                    if (i % 2 == 0) {
                        doubleCouter.incrementSecond();
                    }

                    synchronized (doubleCouter) {
                        doubleCouter.incrementFirst();
                        doubleCouter.incrementSecond();
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.getValue());
        System.out.println(atomicInteger.get());
        System.out.println(doubleCouter.toString());
    }



    private static class Counter {
        private int value;

        public Counter() {
            this.value = 0;
        }

        public Counter(int value) {
            this.value = value;
        }


        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public synchronized void increment() {
            this.value++;
        }
    }

    private static class DoubleCouter {
        private Object lock1 = new Object();
        private Object lock2 = new Object();

        private int first;
        private int second;

        public DoubleCouter() {
            this.first = 0;
            this.second = 0;
        }

        public void incrementFirst() {
            synchronized (lock1) {
                this.first++;
            }
        }

        public void incrementSecond() {
            synchronized (lock2) {
                this.second++;
            }
        }

        @Override
        public String toString() {
            return "DoubleCouter{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }




}
