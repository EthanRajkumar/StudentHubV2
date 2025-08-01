package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class StudentSearchCourseController extends SceneController {

    @FXML
    private VBox searchCourseVBox;

    @FXML
    protected void onStudentReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubStudentMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourse() throws IOException {

    }

}
