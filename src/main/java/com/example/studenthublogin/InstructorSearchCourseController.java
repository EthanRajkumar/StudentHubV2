package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class InstructorSearchCourseController extends SceneController {

    @FXML
    private VBox searchCourseVBox;

    @FXML
    protected void onInstructorReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubInstructorMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourse() throws IOException {

    }

}
