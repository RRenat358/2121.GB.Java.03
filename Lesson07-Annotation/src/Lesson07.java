



public class Lesson07 {
    public static void main(String[] args) throws ClassNotFoundException {

        //класс Class
        Cat cat = new Cat("Basik", "red", 5, 8);

        Class<Cat> catClass1 = Cat.class;
        Class<Cat> catClass2 = (Class<Cat>) cat.getClass();
        Class<?> catClass3 = Class.forName("java.lang.Byte");

        System.out.println(catClass1.getName());
        System.out.println(catClass1.getSimpleName());

        System.out.println(catClass2.getName());
        System.out.println(catClass2.getSimpleName());




    }

}
