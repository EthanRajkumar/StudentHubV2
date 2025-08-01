package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class InstructorSearchCourseAdvController extends SceneController {

    @FXML
    private VBox searchCourseAdvVBox;

    @FXML
    protected void onInstructorReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubInstructorMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourseAdv() throws IOException {

    }
}
