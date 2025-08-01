package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class AdminAddUserController {

    @FXML
    private VBox adminAddUserVBox;

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onAdminSelectNewStudent() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminAddNewStudent.fxml");
    }

    @FXML
    protected void onAdminSelectNewInstructor() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminAddNewInstructor.fxml");
    }

}
