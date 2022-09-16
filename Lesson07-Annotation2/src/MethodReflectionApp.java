import java.lang.reflect.Method;
import java.util.Arrays;


public class MethodReflectionApp {
    public static void main(String[] args) {
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



        System.out.println("=== 01 ===============================================");



    }




}
