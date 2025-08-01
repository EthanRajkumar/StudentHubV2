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

public class StudentAddCourseController extends SceneController {

    @FXML
    private VBox studentAddCourseVBox;

    @FXML
    protected void onStudentReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubStudentMenu.fxml");
    }

    @FXML
    protected void onStudentEnterAddCourse() throws IOException {

    }
}
