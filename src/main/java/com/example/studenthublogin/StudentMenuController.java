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

public class StudentMenuController {

    @FXML
    private VBox studentMenuVBox;

    @FXML
    protected void onStudentSelectCourseSearchPress() throws IOException {
        new SceneSwitch(studentMenuVBox, "StudentHubStudentSearchCourse.fxml");
    }

    @FXML
    protected void onStudentSelectAdvCourseSearchPress() throws IOException {
        new SceneSwitch(studentMenuVBox, "StudentHubStudentSearchCourseAdv.fxml");
    }

    @FXML
    protected void onStudentSelectAddCoursePress() throws IOException {
        new SceneSwitch(studentMenuVBox, "StudentHubStudentAddCourse.fxml");
    }

    @FXML
    protected void onStudentSelectRemoveCoursePress() throws IOException {
        new SceneSwitch(studentMenuVBox, "StudentHubStudentRemoveCourse.fxml");
    }

    @FXML
    protected void onStudentSelectShowSchedulePress() throws IOException {
        new SceneSwitch(studentMenuVBox, "StudentHubStudentShowSchedule.fxml");
    }

    @FXML
    protected void onStudentSelectLogoutPress() throws IOException {
        new SceneSwitch(studentMenuVBox, "StudentHubLogin.fxml");
    }

}
