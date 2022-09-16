import java.lang.reflect.Constructor;
import java.util.Arrays;

public class ConstructorReflectionApp {

    public static void main(String[] args) {
        Class bikeClass = Bike.class;

        Constructor[] declaredConstructors = bikeClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(Arrays.toString(declaredConstructor.getParameterTypes()));
        }

    }
}
