package com.example.studenthublogin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SqlExecuter.OpenDatabase("jdbc:sqlite:data/assignment3.db");
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StudentHubLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);
        stage.setTitle("Student Hub V2.0.1");
        stage.setScene(scene);
        stage.show();
        SceneSwapper.stage = stage;
    }

    public static void main(String[] args) {
        launch();
    }
}