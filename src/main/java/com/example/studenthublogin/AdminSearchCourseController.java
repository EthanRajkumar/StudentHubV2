package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AdminSearchCourseController {

    @FXML
    private VBox searchCourseVBox;

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        new SceneSwitch(searchCourseVBox, "StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourse() throws IOException {

    }


}
