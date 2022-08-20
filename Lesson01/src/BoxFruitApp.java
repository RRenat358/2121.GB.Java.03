


public class BoxFruitApp {
    public static void main(String[] args) {

        Box<Apple> boxApple = new Box<>();
        Box<Orange> boxOrange1 = new Box<>();
        Box<Orange> boxOrange2 = new Box<>();

        Apple apple = new Apple();
        Orange orange = new Orange();

        System.out.println(apple.fruitToString());
        System.out.println(orange.fruitToString());

        for (int i = 0; i < 10; i++) {
            boxApple.addFruit(apple);
        }

        for (int i = 0; i < 2; i++) {
            boxOrange1.addFruit(orange);
        }

        for (int i = 0; i < 4; i++) {
            boxOrange2.addFruit(orange);
        }


        System.out.println();
        System.out.println("Ящик boxApple весит == " + boxApple.getWeightBox());
        System.out.println("Ящик boxOrange1 весит == " + boxOrange1.getWeightBox());
        System.out.println("Ящик boxOrange2 весит == " + boxOrange2.getWeightBox());

        System.out.println("Сравнение ящиков == " + boxOrange1.compare(boxApple));

        boxOrange1.switchFruitInBox(boxOrange2);

        System.out.println();
        System.out.println("Ящик boxApple весит == " + boxApple.getWeightBox());
        System.out.println("Ящик boxOrange1 весит == " + boxOrange1.getWeightBox());
        System.out.println("Ящик boxOrange2 весит == " + boxOrange2.getWeightBox());

        System.out.println("Сравнение ящиков == " + boxOrange2.compare(boxApple));


    }

}
