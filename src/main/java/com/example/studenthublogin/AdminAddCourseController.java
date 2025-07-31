package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class AdminAddCourseController {

    @FXML
    private CheckBox mondayCheckBox, tuesdayCheckBox, wednesdayCheckBox, thursdayCheckBox, fridayCheckBox, springCheckBox, summerCheckBox, fallCheckBox;

    @FXML
    private TextField courseNameTextField, courseIDTextField, courseDeptTextField, courseTimeStartTextField, courseTimeEndTextField, courseYearTextField,
            courseCreditsTextField, courseSeatsTextField;

    @FXML
    private Label resultMsg;

    @FXML
    private VBox adminAddCourseVBox;

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        new SceneSwitch(adminAddCourseVBox, "StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onMondayToggle() {
        if (mondayCheckBox.isSelected()) {

        }
        else {

        }
    }

    @FXML
    protected void onTuesdayToggle() {
        if (tuesdayCheckBox.isSelected()) {

        }
        else {

        }
    }

    @FXML
    protected void onWednesdayToggle() {
        if (wednesdayCheckBox.isSelected()) {

        }
        else {

        }
    }

    @FXML
    protected void onThursdayToggle() {
        if (thursdayCheckBox.isSelected()) {

        }
        else {

        }
    }

    @FXML
    protected void onFridayToggle() {
        if (fridayCheckBox.isSelected()) {

        }
        else {

        }
    }

    @FXML
    protected void onSpringToggle() {
        if (springCheckBox.isSelected()) {

        }
        else {

        }
    }

    @FXML
    protected void onSummerToggle() {
        if (summerCheckBox.isSelected()) {

        }
    }

    @FXML
    protected void onFallToggle() {
        if (fallCheckBox.isSelected()) {

        }
        else {

        }
    }

    @FXML
    protected void onCreateCourseConfirm() {
        if (!courseNameTextField.getText().isEmpty() && !courseIDTextField.getText().isEmpty() && !courseDeptTextField.getText().isEmpty()
                && !courseTimeStartTextField.getText().isEmpty() && !courseTimeEndTextField.getText().isEmpty() && !courseYearTextField.getText().isEmpty()
                && !courseCreditsTextField.getText().isEmpty() && !courseSeatsTextField.getText().isEmpty()
                && (springCheckBox.isSelected() || summerCheckBox.isSelected() || fallCheckBox.isSelected())
                && (mondayCheckBox.isSelected() || tuesdayCheckBox.isSelected() || wednesdayCheckBox.isSelected() || thursdayCheckBox.isSelected()
                || fridayCheckBox.isSelected())) {

            resultMsg.setText("");
        }
        else {
            resultMsg.setText("One or more fields have been left blank");
        }
    }

}
