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

public class InstructorMenuController {

    @FXML
    private VBox instructorMenuVBox;

    @FXML
    protected void onInstructorSelectCourseSearch() throws IOException {
        new SceneSwitch(instructorMenuVBox, "StudentHubInstructorSearchCourse.fxml");
    }

    @FXML
    protected void onInstructorSelectAdvCourseSearch() throws IOException {
        new SceneSwitch(instructorMenuVBox, "StudentHubInstructorSearchCourseAdv.fxml");
    }

    @FXML
    protected void onInstructorSelectShowSchedule() throws IOException {
        new SceneSwitch(instructorMenuVBox, "StudentHubInstructorShowSchedule.fxml");
    }

    @FXML
    protected void onInstructorSelectShowCourseRoster() throws IOException {
        new SceneSwitch(instructorMenuVBox, "StudentHubInstructorShowCourseRoster.fxml");
    }

    @FXML
    protected void onInstructorSelectSearchCourseRoster() throws IOException {
        new SceneSwitch(instructorMenuVBox, "StudentHubInstructorSearchCourseRoster.fxml");
    }

    @FXML
    protected void onInstructorSelectLogoutPress() throws IOException {
        new SceneSwitch(instructorMenuVBox, "StudentHubLogin.fxml");
    }

}
