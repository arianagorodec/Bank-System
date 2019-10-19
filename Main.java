package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setTitle("Работа с клиентами");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) throws ClassNotFoundException {
        launch(args);

        //connecting to bd
        /*        String userName = "root";
        String password = "28092003";
        String connectionUrl = "jdbc:mysql://localhost:3306/rppzl"+
                "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password)) {
          //  System.out.println("We connecting");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
