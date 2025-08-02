package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminAddNewInstructorController {

    @FXML
    private TextField setInstructorFirstName, setInstructorLastName, setInstructorID, setInstructorYearOfHire, setInstructorDept, setInstructorTitle, setInstructorEmail;

    @FXML
    private Label resultMsg;

    @FXML
    private VBox adminAddNewInstructorVBox;

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onCreateInstructor() {
        if (!setInstructorFirstName.getText().isEmpty() && !setInstructorLastName.getText().isEmpty() && !setInstructorID.getText().isEmpty()
                && !setInstructorYearOfHire.getText().isEmpty() && !setInstructorDept.getText().isEmpty() && !setInstructorEmail.getText().isEmpty()
                && !setInstructorTitle.getText().isEmpty()) {

            int hireYearInput = -1;

            try { hireYearInput = Integer.parseInt(setInstructorYearOfHire.getText()); }
            catch (Exception e) { System.out.println(e); }

            ResultSet rs = SqlExecuter.RunQuery("", "SELECT * FROM LOGIN WHERE EMAIL = '" + setInstructorEmail.getText() + "'");

            try
            {
                if (rs.next())
                {
                    resultMsg.setText("This email is already taken.");
                    return;
                }
            }

            catch (SQLException e) { System.out.println(e); }

            rs = SqlExecuter.RunQuery("", "SELECT * FROM INSTRUCTOR WHERE ID = '" + setInstructorID.getText() + "'");

            try
            {
                if (rs.next())
                {
                    resultMsg.setText("This ID is already taken.");
                    return;
                }
            }
            catch (SQLException e) { System.out.println(e); }

            if (hireYearInput <= 0)
            {
                resultMsg.setText("Invalid hire year. Please insert values > 1.");
                return;
            }

            Admin.CreateInstructor(setInstructorFirstName.getText(), setInstructorLastName.getText(), setInstructorID.getText(), setInstructorEmail.getText(), setInstructorTitle.getText(), setInstructorDept.getText(), hireYearInput);

            SqlExecuter.RunUpdate("", "INSERT INTO LOGIN VALUES ('" + setInstructorEmail.getText() + "', 'instructor', '" + setInstructorEmail.getText() + "')");

            resultMsg.setText("Successfully added instructor to database.");
        }
        else {
            resultMsg.setText("One or more fields have been left blank");
        }
    }

}
