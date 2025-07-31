package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class AdminAddNewStudentController {

    @FXML
    private TextField setStudentFirstName, setStudentLastName, setStudentID, setStudentGradYear, setStudentMajor, setStudentEmail;

    @FXML
    private Label resultMsg;

    @FXML
    private VBox adminAddNewStudentVBox;

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        new SceneSwitch(adminAddNewStudentVBox, "StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onCreateStudent() {
        if (!setStudentFirstName.getText().isEmpty() && !setStudentLastName.getText().isEmpty() && !setStudentID.getText().isEmpty()
                && !setStudentGradYear.getText().isEmpty() && !setStudentMajor.getText().isEmpty() && !setStudentEmail.getText().isEmpty()) {

            resultMsg.setText("");
        }
        else {
            resultMsg.setText("One or more fields have been left blank");
        }
    }

}
