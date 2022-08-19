import java.util.ArrayList;


public class Box <T extends Fruit> {

    private double weightBox = 0.0;
    private double weightBoxTotal = 0.0;

    ArrayList<T> boxFruits = new ArrayList<>();


    public void addFruit(T o) {
        boxFruits.add(o);
        this.weightBox = this.weightBox + o.getWeight();
    }


    public double getWeightBox() {
        weightBoxTotal = 0.0;
        for (T boxFruit : boxFruits) {
            weightBoxTotal = weightBoxTotal + boxFruit.getWeight();
        }
        return weightBoxTotal;
    }


}
