package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class StudentSearchCourseAdvController {

    @FXML
    private VBox searchCourseAdvVBox;

    @FXML
    protected void onStudentReturnToMenuPress() throws IOException {
        new SceneSwitch(searchCourseAdvVBox, "StudentHubStudentMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourseAdv() throws IOException {

    }

}
