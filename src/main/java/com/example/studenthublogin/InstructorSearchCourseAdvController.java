package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class InstructorSearchCourseAdvController {

    @FXML
    private VBox searchCourseAdvVBox;

    @FXML
    protected void onInstructorReturnToMenuPress() throws IOException {
        new SceneSwitch(searchCourseAdvVBox, "StudentHubInstructorMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourseAdv() throws IOException {

    }
}
