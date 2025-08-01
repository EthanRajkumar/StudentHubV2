package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminAddNewStudentController {

    @FXML
    private TextField setStudentFirstName, setStudentLastName, setStudentID, setStudentGradYear, setStudentMajor, setStudentEmail;

    @FXML
    private Label resultMsg;

    @FXML
    private VBox adminAddNewStudentVBox;

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onCreateStudent() {
        if (!setStudentFirstName.getText().isEmpty() && !setStudentLastName.getText().isEmpty() && !setStudentID.getText().isEmpty()
                && !setStudentGradYear.getText().isEmpty() && !setStudentMajor.getText().isEmpty() && !setStudentEmail.getText().isEmpty()) {

            int gradyearInput = -1;

            try { gradyearInput = Integer.parseInt(setStudentGradYear.getText()); }
            catch (Exception e) { System.out.println(e); }

            ResultSet rs = SqlExecuter.RunQuery("", "SELECT * FROM LOGIN WHERE EMAIL = '" + setStudentEmail.getText() + "'");

            try
            {
                if (rs.next())
                {
                    resultMsg.setText("This email is already taken.");
                    return;
                }
            }

            catch (SQLException e) { System.out.println(e); }

            rs = SqlExecuter.RunQuery("", "SELECT * FROM STUDENT WHERE ID = '" + setStudentID.getText() + "'");

            try
            {
                if (rs.next())
                {
                    resultMsg.setText("This ID is already taken.");
                    return;
                }
            }
            catch (SQLException e) { System.out.println(e); }

            if (gradyearInput <= 0)
            {
                resultMsg.setText("Invalid graduation year. Please insert values > 1.");
                return;
            }

            Admin.CreateStudent(setStudentFirstName.getText(), setStudentLastName.getText(), setStudentID.getText(), setStudentEmail.getText(), setStudentMajor.getText(), gradyearInput);

            SqlExecuter.RunUpdate("", "INSERT INTO LOGIN VALUES ('" + setStudentEmail.getText() + "', 'student', '" + setStudentEmail.getText() + "')");

            resultMsg.setText("Successfully added student to database.");
        }
        else {
            resultMsg.setText("One or more fields have been left blank");
        }
    }

}
