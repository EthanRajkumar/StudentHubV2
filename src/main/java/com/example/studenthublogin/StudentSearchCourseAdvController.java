package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class StudentSearchCourseAdvController extends SceneController {

    @FXML
    private VBox searchCourseAdvVBox;

    @FXML
    protected void onStudentReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubStudentMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourseAdv() throws IOException {

    }

}
