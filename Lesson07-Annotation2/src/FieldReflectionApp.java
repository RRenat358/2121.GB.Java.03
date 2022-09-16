import java.lang.reflect.Field;

public class FieldReflectionApp {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class bikeClass = Bike.class;

        Field[] fields = bikeClass.getDeclaredFields();

        System.out.println("=== 01 ===============================================");
        for (Field f : fields) {
            System.out.println("name = " + f.getName() + " type = "+ f.getType().getName());
        }

        System.out.println("=== 02 ===============================================");
        Bike bike = new Bike();
        System.out.println(bike);

        Field field = bikeClass.getField("model");
        field.set(bike, "CanyonS");

        Field yearField = bikeClass.getDeclaredField("year");
        yearField.setAccessible(true);
        yearField.set(bike, 2021);

        System.out.println(bike);


    }
}
