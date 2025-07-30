package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class InstructorSearchCourseController {

    @FXML
    private VBox searchCourseVBox;

    @FXML
    protected void onInstructorReturnToMenuPress() throws IOException {
        new SceneSwitch(searchCourseVBox, "StudentHubInstructorMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourse() throws IOException {

    }

}
