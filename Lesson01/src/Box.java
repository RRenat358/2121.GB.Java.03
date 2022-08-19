import java.util.ArrayList;
import java.util.List;



public class Box <T extends Fruit> {

    private double weightBox = 0.0f;

    ArrayList<T> boxFruit = new ArrayList<>();


    public void addFruit(T o) {
        boxFruit.add(o);
        this.weightBox = this.weightBox + o.getWeight();
    }


    public double totalWeightBox() {
        return 0;
    }




    public double getWeightBox() {
        weightBox = 0.0f;
        for (T boxFruit : boxFruit) {
            weightBox = weightBox + boxFruit.getWeight();


        }



        return weightBox;
    }


}
