import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Lesson07_HW {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {

        Class methodR = MethodR.class;

        Method methodBeforeSuite = null;
        Method methodAfterSuite = null;
        List<Method> methodTestRList = new ArrayList<>();
//        List<Method> methodList = new ArrayList<>();
        Map<Integer, Method> methodList = new LinkedHashMap<>();
//        TreeMap<Integer, Method> methodList = new TreeSet<>();
//        HashMap<Integer, Method> methodList = new HashMap<>();
//        LinkedHashMap<Integer, Method> methodList = new LinkedHashMap<>();
//        SortedMap<Integer, Method> methodList = Collections.emptySortedMap();

        Method[] methods = methodR.getDeclaredMethods();

        System.out.println(methods.length);
//        System.out.println(Arrays.toString(methods));


        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                if (methodList.get(0) != null) {
                    //exeption
                }
                methodList.put(-1, methods[i]);
            }

            if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                if (methodList.get(methods.length) != null) {
                    //exeption
                }
                methodList.put(11, methods[i]);
            }

            if (methods[i].isAnnotationPresent(TestR.class)) {
                methodList.put(methods[i].getAnnotation(TestR.class).priority(), methods[i]);
                System.out.println(methods[i].getAnnotation(TestR.class).priority());
            }

        }

/*
//        methodList.get(3).invoke(methodR);
        System.out.println(methodList.equals(3));
        System.out.println(methodList.entrySet().equals(3));
        System.out.println(methodList.get(3));

//        methodList.get(3).setAccessible(true);
        methodList.get(3).setAccessible(true);
        methodList.get(3).invoke(methodR.getConstructor().newInstance());

        methodList.get(9).setAccessible(true);
        methodList.get(9).invoke(methodR.getConstructor().newInstance());

*/

/*
        for (Map.Entry<Integer, Method> e : methodList.entrySet()) {

            Method value = e.getValue();

            value.setAccessible(true);
            value.invoke(methodR.getConstructor().newInstance());
        }

*/





        System.out.println("=================================");


//        Collections.emptySortedMap();
//        Collections.emptySortedMap();
//
//        SortedMap<String, Date> s = Collections.emptySortedMap();
//
//


//        Map<Integer, Method> methodList = new TreeMap<>();
        Map<Integer, Method> methodListSort = new TreeMap<>(methodList);
//
//
        methodListSort.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });








    }
}
