import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

public class Lesson07 {
    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException, NoSuchFieldException,
            IllegalAccessException {

        //класс Class
        Cat cat = new Cat("Basik", "red", 5, 8);

        //==================================================
        Class<Cat> catClass1 = Cat.class;
        Class<Cat> catClass2 = (Class<Cat>) cat.getClass();
        Class<?> catClass3 = Class.forName("java.lang.Byte");

        System.out.println("==================================================");
        System.out.println(catClass1.getName());
        System.out.println(catClass1.getSimpleName());

        System.out.println(catClass2.getName());
        System.out.println(catClass2.getSimpleName());

        System.out.println("==================================================");
        int modifiers = catClass1.getModifiers();
        System.out.println(Modifier.isInterface(modifiers));

        System.out.println("==================================================");
        System.out.println(catClass1.getSuperclass());
        System.out.println(catClass1.getInterfaces());

        System.out.println("==================================================");
        Method[] methods = catClass1.getMethods();
        Method[] declaredMethods = catClass1.getDeclaredMethods();
//        catClass1.getMethod("info1", String.class, Integer.class);

        System.out.println("==================================================");
        Field[] fields = catClass1.getFields();
        Field[] declaredFields = catClass1.getDeclaredFields();

        for (Field f : declaredFields) {
            System.out.println(f);
        }

        System.out.println("==================================================");
        System.out.println(cat.getAge());
        Field age = catClass1.getDeclaredField("age");
        age.setAccessible(true);
        age.set(cat, 13);
        System.out.println(cat.getAge());

        System.out.println("==================================================");

        //@Deprecated
        Date date = new Date(2022, 12, 27);
        System.out.println(date);

        System.out.println("==================================================");
        Cat cat1 = new Cat("Murzik", "black", 1, 5);
        Class<Cat> catClass = Cat.class;

        for (Method method : catClass.getMethods()) {
            if(method.isAnnotationPresent())
        }


    }

}
