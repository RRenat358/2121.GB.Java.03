import java.sql.Connection;



public class DataBaseApp {

    private static Connection connection;

    public static void main(String[] args) {
        try {
            connect();

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            disconnect();
        }
    }



}
