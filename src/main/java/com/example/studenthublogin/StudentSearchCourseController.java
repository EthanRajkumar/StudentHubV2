package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class StudentSearchCourseController {

    @FXML
    private VBox searchCourseVBox;

    @FXML
    protected void onStudentReturnToMenuPress() throws IOException {
        new SceneSwitch(searchCourseVBox, "StudentHubStudentMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourse() throws IOException {

    }

}
