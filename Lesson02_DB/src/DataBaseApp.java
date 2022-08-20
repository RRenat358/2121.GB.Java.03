import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBaseApp {

    private static Connection connection;
    public static Statement statement;

    public static void main(String[] args) {
        try {
            connect();

            createTable();
            insertUser();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void connect() throws SQLException {
//        connection = DriverManager.getConnection("jdbc:sqlite:javadb.db");
        connection = DriverManager.getConnection("jdbc:sqlite:Chat-220820.sqlite");
        statement = connection.createStatement();
    }


    private static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void createTable() throws SQLException {
        statement.executeUpdate("create table if not exists User\n" +
                "(\n" +
                "    id integer primary key autoincrement not null,\n" +
                "    name text not null ,\n" +
                "    password text not null ,\n" +
                "    age integer\n" +
                ")");
    }

    private static void insertUser() throws SQLException {
        for (int i = 1; i <= 5; i++) {
            statement.executeUpdate(
                    "insert into User (name, password)\n" +
                            "values ('User_" + i + "', '" + i + "')");
        }
    }

    private static void readDB() {

    }


}
