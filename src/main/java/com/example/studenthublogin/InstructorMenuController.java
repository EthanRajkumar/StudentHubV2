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

public class InstructorMenuController extends SceneController {

    @FXML
    private VBox instructorMenuVBox;

    @FXML
    protected void onInstructorSelectCourseSearch() throws IOException {
        SceneSwapper.SwapScene("StudentHubInstructorSearchCourse.fxml");
    }

    @FXML
    protected void onInstructorSelectAdvCourseSearch() throws IOException {
        SceneSwapper.SwapScene("StudentHubInstructorSearchCourseAdv.fxml");
    }

    @FXML
    protected void onInstructorSelectShowSchedule() throws IOException {
        SceneSwapper.SwapScene("StudentHubInstructorShowSchedule.fxml");
    }

    @FXML
    protected void onInstructorSelectShowCourseRoster() throws IOException {
        SceneSwapper.SwapScene("StudentHubInstructorShowCourseRoster.fxml");
    }

    @FXML
    protected void onInstructorSelectSearchCourseRoster() throws IOException {
        SceneSwapper.SwapScene("StudentHubInstructorSearchCourseRoster.fxml");
    }

    @FXML
    protected void onInstructorSelectLogoutPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubLogin.fxml");
    }

}
