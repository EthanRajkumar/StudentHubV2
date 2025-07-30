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

public class InstructorSearchCourseRosterController {

    @FXML
    private VBox instructorSearchCourseRosterVBox;

    @FXML
    protected void onInstructorReturnToMenuPress() throws IOException {
        new SceneSwitch(instructorSearchCourseRosterVBox, "StudentHubInstructorMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourseID() throws IOException {

    }

    @FXML
    protected void onUserEnterSearchName() throws IOException {

    }

}
