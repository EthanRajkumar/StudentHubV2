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

public class HelloController {
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label errorText;

    @FXML
    private VBox loginVBox;

    @FXML
    protected void onLoginButtonClick() throws IOException {
        //to do: change if statement condition to check for valid credentials from database
        if (usernameTextField.getText().equals(passwordTextField.getText())) {
            errorText.setText("Logging in...");
            //this part: check user credentials to transition to student/instructor/admin scenes accordingly
            //transition to student scene (if blah blah blah database query blah blah blah)
            //new SceneSwitch(loginVBox, "StudentHubStudentMenu.fxml");
            new SceneSwitch(loginVBox, "StudentHubInstructorMenu.fxml");
        }
        else {
            errorText.setText("Invalid login credentials; please try again");
        }

    }

    //for pasting at end of "<VBox..." line in fxml files after making SceneBuilder changes
    //fx:controller="com.example.studenthublogin.*Controller"

}