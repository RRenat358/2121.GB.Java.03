import java.util.Arrays;
import java.util.List;

public class BoxFruitApp {
    public static void main(String[] args) {

        Box<Apple> boxApple = new Box<>();
        Box<Orange> boxOrange = new Box<>();

        for (int i = 0; i < 5; i++) {
            boxApple.addFruit(new Apple());
        }
        for (int i = 0; i < 2; i++) {
            boxOrange.addFruit(new Orange());
        }


        System.out.println(boxApple.toString());


    }

}
