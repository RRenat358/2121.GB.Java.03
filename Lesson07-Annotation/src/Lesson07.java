import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

public class Lesson07 {
    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException, NoSuchFieldException,
            IllegalAccessException, InvocationTargetException {

        //класс Class
        Cat cat = new Cat("Basik", "red", 5, 8);

        //==================================================
        Class<Cat> catClass1 = Cat.class;
        Class<Cat> catClass2 = (Class<Cat>) cat.getClass();
        Class<?> catClass3 = Class.forName("java.lang.Byte");

        System.out.println("=== 01 ===============================================");
        System.out.println(catClass1.getName());
        System.out.println(catClass1.getSimpleName());

        System.out.println(catClass2.getName());
        System.out.println(catClass2.getSimpleName());

        System.out.println("=== 02 ===============================================");
        int modifiers = catClass1.getModifiers();
        System.out.println(Modifier.isInterface(modifiers));

        System.out.println("=== 03 ===============================================");
        System.out.println(catClass1.getSuperclass());
        System.out.println(catClass1.getInterfaces());

        System.out.println("=== 04 ===============================================");
        Method[] methods = catClass1.getMethods();
        Method[] declaredMethods = catClass1.getDeclaredMethods();
        System.out.println(catClass1.getMethod("info2", String.class, Integer.class));

        System.out.println("=== 05 ===============================================");
        Field[] fields = catClass1.getFields();
        Field[] declaredFields = catClass1.getDeclaredFields();

        for (Field f : declaredFields) {
            System.out.println(f);
        }

        System.out.println("=== 06 ===============================================");
        System.out.println(cat.getAge());
        Field age = catClass1.getDeclaredField("age");
        age.setAccessible(true);
        age.set(cat, 13);
        System.out.println(cat.getAge());

        System.out.println("=== 07 ===============================================");

        //@Deprecated
        Date date = new Date(2022, 12, 27);
        System.out.println(date);

        System.out.println("=== 08 ===============================================");
        Cat cat1 = new Cat("Murzik", "black", 1, 5);
        Class<Cat> catClass = Cat.class;

        for (Method method : catClass.getMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                if (method.getAnnotation(MyAnnotation.class).priority() > 4) {

                    System.out.println(method.getAnnotation(MyAnnotation.class).priority());
                    method.invoke(cat1);

                }
            }
        }


    }

}
