


import java.util.ArrayList;


public class Box<T extends Fruit> {

    private double weightBox = 0.0;
    private double weightBoxTotal = 0.0;

    ArrayList<T> boxFruits = new ArrayList<>();


    public void addFruit(T o) {
        boxFruits.add(o);
        this.weightBox = this.weightBox + o.getWeight();
    }


    public double getWeightBox() {
        weightBoxTotal = 0.0;
        for (T boxFruit : this.boxFruits) {
            weightBoxTotal = weightBoxTotal + boxFruit.getWeight();
        }
        return weightBoxTotal;
    }

    public boolean compare(Box<? extends Fruit> anyBox) {
        return Math.abs(this.getWeightBox() - anyBox.getWeightBox()) < 0.0001;
    }


    public void switchFruitInBox(Box<T> anyBox) {
        for (T boxFruit : this.boxFruits) {
            anyBox.addFruit(boxFruit);
        }
        this.boxFruits.clear();
    }


}
