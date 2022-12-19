package prueba.sistemasweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/extraprueba";
    //private static String url = "jdbc:mysql://db4freetest.net:3306/db4freetest";
    private static String driverName = "com.mysql.cj.jdbc.Driver"; //"com.mysql.jdbc.Driver"; // com.mysql.cj.jdbc.Driver
    private static String username = "root";
    private static String password = "cisco";
    // variable de conexion
    private static Connection connection = null;

    public static Connection getConnection(){
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(" SQL:" + e);
        } catch (ClassNotFoundException e){
            System.out.println("Driver:" + e);
        }
        return connection;
    }

}
