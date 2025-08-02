package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminAddCourseController extends SceneController {

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
        SceneSwapper.SwapScene("StudentHubAdminMenu.fxml");
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

            int crnInput = -1, yearInput = -1, timeStartInput = -1, timeEndInput = -1, seatsInput = -1, creditInput = -1;

            try { crnInput = Integer.parseInt(courseIDTextField.getText()); }
            catch (Exception e) { System.out.println(e); }

            if (crnInput < 0 || crnInput > 99999)
            {
                resultMsg.setText("Invalid CRN. Enter a value between 0 and 99999");
                return;
            }

            ResultSet rs = SqlExecuter.RunQuery("", "SELECT * FROM COURSE WHERE CRN = " + crnInput + "");

            try
            {
                if (rs.next())
                {
                    resultMsg.setText("This CRN is already taken.");
                    return;
                }
            }
            catch (SQLException e) { System.out.println(e); }

            try { yearInput = Integer.parseInt(courseYearTextField.getText()); }
            catch (Exception e) { System.out.println(e); }

            if (yearInput < 0)
            {
                resultMsg.setText("Invalid year. Enter a value > 0.");
                return;
            }

            try { timeStartInput = Integer.parseInt(courseTimeStartTextField.getText()); }
            catch (Exception e) { System.out.println(e); }

            int startTimeHour = timeStartInput / 100, startTimeMinute = timeStartInput % 100;

            if (startTimeHour < 0 || startTimeHour > 23)
            {
                resultMsg.setText("Invalid starting hour. Please enter an hour between 0 and 23.");
                return;
            }

            if (startTimeMinute < 0 || startTimeMinute > 59)
            {
                resultMsg.setText("Invalid starting minute. Please enter an hour between 0 and 59.");
                return;
            }

            try { timeEndInput = Integer.parseInt(courseTimeEndTextField.getText()); }
            catch (Exception e) { System.out.println(e); }

            int endTimeHour = timeEndInput / 100, endTimeMinute = timeEndInput % 100;

            if (endTimeHour < 0 || endTimeHour > 23)
            {
                resultMsg.setText("Invalid ending hour. Please enter an hour between 0 and 23.");
                return;
            }

            if (endTimeMinute < 0 || startTimeMinute > 59)
            {
                resultMsg.setText("Invalid ending minute. Please enter a minute between 0 and 59.");
                return;
            }

            try { seatsInput = Integer.parseInt(courseSeatsTextField.getText()); }
            catch (Exception e) { System.out.println(e); }

            if (seatsInput < 1)
            {
                resultMsg.setText("Invalid seat count. Enter a value > 0.");
                return;
            }

            try { creditInput = Integer.parseInt(courseCreditsTextField.getText()); }
            catch (Exception e) { System.out.println(e); }

            if (creditInput < 0)
            {
                resultMsg.setText("Invalid credit count. Enter a value > 0.");
                return;
            }

            StringBuilder sb = new StringBuilder();

            if (mondayCheckBox.isSelected())
                sb.append("Monday ");
            if (tuesdayCheckBox.isSelected())
                sb.append("Tuesday ");
            if (wednesdayCheckBox.isSelected())
                sb.append("Wednesday ");
            if (thursdayCheckBox.isSelected())
                sb.append("Thursday ");
            if (fridayCheckBox.isSelected())
                sb.append("Friday ");

            StringBuilder sb1 = new StringBuilder();

            if (fallCheckBox.isSelected())
                sb1.append("Fall ");
            if (springCheckBox.isSelected())
                sb1.append("Spring ");
            if (summerCheckBox.isSelected())
                sb1.append("Summer ");

            int time = (timeStartInput * 10000) + timeEndInput;
            String[] days = sb.toString().trim().split(" ");
            String[] semesters = sb1.toString().trim().split(" ");
            Admin.CreateCourse(courseNameTextField.getText(), courseDeptTextField.getText(), crnInput, time, days, semesters, yearInput, creditInput, seatsInput);
            resultMsg.setText("Successfully added course to database.");
        }
        else {
            resultMsg.setText("One or more fields have been left blank");
        }
    }

}
