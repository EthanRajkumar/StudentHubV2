package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class AdminLinkInstructorController {

    @FXML
    private VBox adminLinkInstructorVBox;

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        new SceneSwitch(adminLinkInstructorVBox, "StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onLink() {

    }



}
