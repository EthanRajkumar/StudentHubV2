package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController extends SceneController {
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
        String loginQuery = "SELECT * FROM LOGIN WHERE EMAIL = '" + usernameTextField.getText() + "' AND PASSWORD = '" + passwordTextField.getText() + "';";
        String role = "";
        boolean loginFound = false;
        ResultSet rs = SqlExecuter.RunQuery("", loginQuery);

        try {
            if (rs.next()) {
                loginFound = true;
                role = rs.getString("ROLE").toUpperCase();
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

        if (!loginFound)
            errorText.setText("Invalid login credentials; please try again");
        else {
            errorText.setText("Logging in...");

            rs = SqlExecuter.RunQuery("", "SELECT * FROM " + role + " WHERE EMAIL='" + usernameTextField.getText() + "';");

            switch (role.toUpperCase().trim())
            {
                default:
                case "STUDENT":
                {
                    Globals.Student = SqlSerializer.StudentFromSql(rs);
                    SceneSwapper.SwapScene("StudentHubStudentMenu.fxml");
                    break;
                }

                case "INSTRUCTOR":
                {
                    Globals.Instructor = SqlSerializer.InstructorFromSql(rs);
                    SceneSwapper.SwapScene("StudentHubInstructorMenu.fxml");
                    break;
                }

                case "ADMIN":
                {
                    Globals.Admin = SqlSerializer.AdminFromSql(rs);
                    SceneSwapper.SwapScene("StudentHubAdminMenu.fxml");
                    break;
                }
            }
        }
    }
}