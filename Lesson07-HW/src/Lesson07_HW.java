import java.lang.reflect.Method;
import java.util.Arrays;

public class Lesson07_HW {

    public static void main(String[] args) {

        Class methodR = MethodR.class;


        Method[] methods = methodR.getDeclaredMethods();

        System.out.println(methods.length);
        System.out.println(Arrays.toString(methods));




    }





}
