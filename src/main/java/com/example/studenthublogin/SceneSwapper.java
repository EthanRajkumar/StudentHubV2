package com.example.studenthublogin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwapper {
    public static Stage stage;

    public static SceneController GetController(FXMLLoader loader)
    {
        return loader.getController();
    }

    public static void SwapScene(String sceneUrl)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(sceneUrl));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 640, 400);
            stage.setScene(scene);
            SceneController controller = GetController(fxmlLoader);
            controller.Initialize(stage);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
