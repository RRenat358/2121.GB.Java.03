import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class MethodReflectionApp {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class bikeClass = Bike.class;


        System.out.println("=== 01 ===============================================");
        Method[] declaredMethods = bikeClass.getDeclaredMethods();

        for (Method method : declaredMethods) {

            if (method.getAnnotation(SimpleAnnotation.class) != null) {
                System.out.println("method with annotation");
            }

            method.getDeclaredAnnotations();

            System.out.println(
                    "name = " + method.getName() +
                            " returnType = " + method.getReturnType().getName() +
                            " parameters " + Arrays.toString(method.getParameterTypes())
            );

        }

        System.out.println("=== 02 ===============================================");

        Method method = bikeClass.getDeclaredMethod("setYearAndModel", String.class, int.class);

        NotSimpleAnnotation annotation = method.getDeclaredAnnotation(NotSimpleAnnotation.class);
        System.out.println(annotation.name() + " " + annotation.value());

        System.out.println("=== 03 ===============================================");
        Bike bike = new Bike();
        System.out.println(bike);
        method.setAccessible(true);
        method.invoke(bike, "Pinarello", 2021);
        System.out.println(bike);


    }

}
