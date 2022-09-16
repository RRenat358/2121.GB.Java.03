import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public class Lesson07_HW {

    public static void main(String[] args) {

        Class methodR = MethodR.class;

        Method methodBeforeSuite;
        Method methodAfterSuite;
        List<Method> methodTestRList = new ArrayList<>();
        List<Method> methodList = new ArrayList<>();


        Method[] methods = methodR.getDeclaredMethods();

        System.out.println(methods.length);
        System.out.println(Arrays.toString(methods));


/*
        for (Method method : methods) {


        }
*/


        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                if (methodList.get(0) != null) {
                    //exeption
                }
                methodList.add(0, methods[i]);
            }

            if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                if (methodList.get(methods.length) != null) {
                    //exeption
                }
                methodList.add(methods.length, methods[i]);
            }

            if (methods[i].isAnnotationPresent(TestR.class)) {
                methodList.add(methods[i]);
            }
        }

        methodList.listIterator();





    }


}
