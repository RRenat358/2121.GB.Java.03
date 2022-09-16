import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorReflectionApp {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class bikeClass = Bike.class;

        System.out.println("=== 01 ===============================================");
        Constructor[] declaredConstructors = bikeClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(Arrays.toString(declaredConstructor.getParameterTypes()));
        }
        System.out.println("=== 02 ===============================================");
        Constructor constructor = bikeClass.getDeclaredConstructor(String.class, String.class, int.class);
        Object bike = constructor.newInstance("Canyon", "12345", 2018);
        Bike bike2 = (Bike) constructor.newInstance("Canyon2", "67890", 2019);

        System.out.println(bike);
        System.out.println(bike2);

    }
}
