package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AdminSearchCourseController extends SceneController {

    @FXML
    private VBox searchCourseVBox;

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourse() throws IOException {

    }


}
