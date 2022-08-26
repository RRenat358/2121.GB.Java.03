import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOApp {

    public static void main(String[] args) {

        String demo4 = "dir01/demo4.txt";

        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(demo4))) {
            User user = new User("Den", 42);
            objectOutputStream.writeObject(user);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private static class User implements Serializable {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
