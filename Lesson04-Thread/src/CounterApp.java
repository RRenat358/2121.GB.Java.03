import java.util.concurrent.atomic.AtomicInteger;

public class CounterApp {



    public static void main(String[] args) {
        Counter counter = new Counter();


        AtomicInteger atomicInteger = new AtomicInteger(0);


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    atomicInteger.incrementAndGet();
                    counter.increment();



                }
            }
        };


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

    private static class




}
