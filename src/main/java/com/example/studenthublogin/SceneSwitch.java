package com.example.studenthublogin;

import com.example.studenthublogin.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

public class SceneSwitch {
    public SceneSwitch(VBox currentVBox, String fxml) throws IOException {
        VBox nextVBox = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(fxml)));
        currentVBox.getChildren().removeAll();
        currentVBox.getChildren().setAll(nextVBox);
    }
}
