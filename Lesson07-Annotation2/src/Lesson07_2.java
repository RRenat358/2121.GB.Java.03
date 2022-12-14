import java.lang.reflect.Modifier;

public class Lesson07_2 {

    public static void main(String[] args) {
        Class aClass = "Java".getClass();

        Class strClass = String.class;
        Class intClass = Integer.class;
        Class smallIntClass = int.class;
        Class smallIntArrClass = int[][].class;

        System.out.println("=== 01 ===============================================");
        System.out.println(smallIntArrClass.getName() + " " + smallIntArrClass.getSimpleName());

        System.out.println(new int[][]{{1, 2}, {3, 4}});


        System.out.println("=== 02 ===============================================");
        int modifiers = aClass.getModifiers();
        if (Modifier.isFinal(modifiers)) {
            System.out.println(aClass.getName() + " is final");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println(aClass.getName() + " is abstract");
        }

        if (Modifier.isPublic(modifiers)) {
            System.out.println(aClass.getName() + " is public");
        }

        System.out.println("=== 03 ===============================================");
        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }

        System.out.println("=== 04 ===============================================");
        Class superClass = aClass.getSuperclass();
        System.out.println(superClass);

    }








}
