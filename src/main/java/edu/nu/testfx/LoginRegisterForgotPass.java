package edu.nu.testfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class LoginRegisterForgotPass extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginRegisterForgotPass.class.getResource("FXMLLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 770);
        stage.setTitle("Welcome To Our Library Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}