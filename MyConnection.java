package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    static Connection conn=null;

    public static Connection getConnection() throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/rppzl?allowPublicKeyRetrieval=true&useSSL=false" +
                "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";
        conn = DriverManager.getConnection(connectionUrl, "root", "28092003");
        return conn;
    }
}
