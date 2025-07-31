package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class AdminAddNewInstructorController {

    @FXML
    private TextField setInstructorFirstName, setInstructorLastName, setInstructorID, setInstructorYearOfHire, setInstructorDept, setInstructorTitle, setInstructorEmail;

    @FXML
    private Label resultMsg;

    @FXML
    private VBox adminAddNewInstructorVBox;

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        new SceneSwitch(adminAddNewInstructorVBox, "StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onCreateInstructor() {
        if (!setInstructorFirstName.getText().isEmpty() && !setInstructorLastName.getText().isEmpty() && !setInstructorID.getText().isEmpty()
                && !setInstructorYearOfHire.getText().isEmpty() && !setInstructorDept.getText().isEmpty() && !setInstructorEmail.getText().isEmpty()
                && !setInstructorTitle.getText().isEmpty()) {

            resultMsg.setText("");
        }
        else {
            resultMsg.setText("One or more fields have been left blank");
        }
    }

}
