


public class Orange implements Fruit {

    private double weight = 2.5;


    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String fruitToString() {
        return String.format("Один фрукт %s весит == %s", getClass().getName(), weight);
    }


}
