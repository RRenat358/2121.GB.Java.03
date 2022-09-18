

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Lesson07_HW {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, Exception {

        Class methodR = MethodR.class;

        Method methodBeforeSuite = null;
        Method methodAfterSuite = null;
        List<Method> methodTestRList = new ArrayList<>();

        Method[] methods = methodR.getDeclaredMethods();


        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                if (methodBeforeSuite != null) {
                    //exception
                    throw new MyRuntimeException("\nRuntimeException = @BeforeSuite -- not single");
                }
                methodBeforeSuite = methods[i];
            }

            if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                if (methodAfterSuite != null) {
                    //exception
                    throw new MyRuntimeException("\nRuntimeException = @AfterSuite -- not single");
                }
                methodAfterSuite = methods[i];
            }

            if (methods[i].isAnnotationPresent(TestR.class)) {
                methodTestRList.add(methods[i]);
            }

        }

        System.out.println("=================================");
        methodBeforeSuite.setAccessible(true);
        methodBeforeSuite.invoke(methodR.getConstructor().newInstance());

        System.out.println("=================================");
        for (int i = 1; i <= 10; i++) {
            for (Method method : methodTestRList) {
                if (method.getAnnotation(TestR.class).priority() == i) {
                    method.setAccessible(true);
                    method.invoke(methodR.getConstructor().newInstance());
                }
            }
        }
        System.out.println("=================================");
        methodAfterSuite.setAccessible(true);
        methodAfterSuite.invoke(methodR.getConstructor().newInstance());

        System.out.println("=================================");


    }

    public static class MyRuntimeException extends RuntimeException {
        public MyRuntimeException(String message) {
            super(message);
        }
    }

}

