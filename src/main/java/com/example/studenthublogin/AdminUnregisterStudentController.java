package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class AdminUnregisterStudentController {

    @FXML
    private VBox adminUnregisterStudentVBox;

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onUnregister() {

    }

}
