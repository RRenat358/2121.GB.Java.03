


public class Calculator {

    int a;
    int b;

    private Battery battery;

    public Calculator() {
        battery = new Battery(100);
    }

    public Calculator(Battery battery) {
        this.battery = battery;
    }


    public Integer sum (){
        return a + b;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }



    public int multiply(int a, int b) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return a * b;
    }

    public int division(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        return a / b;
    }


}
