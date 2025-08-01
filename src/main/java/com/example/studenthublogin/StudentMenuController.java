package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StudentMenuController extends SceneController {

    @FXML
    private VBox studentMenuVBox;

    @FXML
    protected void onStudentSelectCourseSearchPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubStudentSearchCourse.fxml");
    }

    @FXML
    protected void onStudentSelectAdvCourseSearchPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubStudentSearchCourseAdv.fxml");
    }

    @FXML
    protected void onStudentSelectAddCoursePress() throws IOException {
        SceneSwapper.SwapScene("StudentHubStudentAddCourse.fxml");
    }

    @FXML
    protected void onStudentSelectRemoveCoursePress() throws IOException {
        SceneSwapper.SwapScene("StudentHubStudentRemoveCourse.fxml");
    }

    @FXML
    protected void onStudentSelectShowSchedulePress() throws IOException {
        SceneSwapper.SwapScene("StudentHubStudentShowSchedule.fxml");
    }

    @FXML
    protected void onStudentSelectLogoutPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubLogin.fxml");
    }

}
