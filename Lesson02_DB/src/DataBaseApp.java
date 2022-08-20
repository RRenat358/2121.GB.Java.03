import java.sql.*;


public class DataBaseApp {

    private static Connection connection;
    public static Statement statement;

    public static void main(String[] args) {
        try {
            connect();

            createTable();
            clearTable();

            insertUser();

            readDB();

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
        statement.executeUpdate("CREATE TABLE IF NOT exists User\n" +
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
                    "INSERT INTO User (name, password)\n" +
                            "VALUES ('User_" + i + "', '" + i + "')");
        }
    }

    private static void readDB() {
        try (ResultSet rs = statement.executeQuery("SELECT * FROM User")) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getInt(4)
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void clearTable() throws SQLException {
        statement.executeUpdate("DELETE FROM User");
        //SQLite Reset Primary Key Field
        statement.executeUpdate("DELETE FROM sqlite_sequence WHERE name='User'");
    }


}
