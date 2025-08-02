package com.example.studenthublogin;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminUnregisterStudentController extends SceneController {

    @FXML
    private VBox adminUnregisterStudentVBox;

    @FXML
    private Label resultMsg;

    @FXML
    private TextField courseID;

    @FXML
    private TextField studentID;

    @FXML
    private TableView courseTable;

    @FXML
    private TableColumn courseTableCourseID, courseTableCourseName, courseTableDept, courseTableTime, courseTableDays, courseTableSemesters, courseTableYear, courseTableCredits, courseTableSeats, courseTableInstructor;

    @Override
    public void Initialize(Stage stage)
    {
        courseTable.setEditable(true);
        courseTableCourseID.setCellValueFactory(new PropertyValueFactory<Course, Integer>("CRN"));
        courseTableCourseName.setCellValueFactory(new PropertyValueFactory<Course, String>("Title"));
        courseTableDept.setCellValueFactory(new PropertyValueFactory<Course, String>("Department"));
        courseTableTime.setCellValueFactory(new PropertyValueFactory<Course, Integer>("Time"));
        courseTableDays.setCellValueFactory(new PropertyValueFactory<Course, String>("DaysString"));
        courseTableSemesters.setCellValueFactory(new PropertyValueFactory<Course, String>("SemestersString"));
        courseTableYear.setCellValueFactory(new PropertyValueFactory<Course, Integer>("Year"));
        courseTableCredits.setCellValueFactory(new PropertyValueFactory<Course, Integer>("Credits"));
        courseTableSeats.setCellValueFactory(new PropertyValueFactory<Course, Integer>("Seats"));
        courseTableInstructor.setCellValueFactory(new PropertyValueFactory<Course, String>("Instructor"));

        courseTable.setItems(FXCollections.observableList(User.GetAllCourses()));
    }

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onUnregister() throws SQLException {
        String studentInput = studentID.getText();

        int crnInput = -1;

        try { crnInput = Integer.parseInt(courseID.getText()); }
        catch (Exception e) { System.out.println(e); }

        ResultSet rs = SqlExecuter.RunQuery("", "SELECT * FROM STUDENT WHERE ID = " + studentInput);

        try {
            if (!rs.next())
            {
                resultMsg.setText("Invalid student ID. Please try again.");
                return;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        rs = SqlExecuter.RunQuery("", "SELECT * FROM COURSE WHERE CRN = " + crnInput);

        try {
            if (!rs.next())
            {
                resultMsg.setText("Invalid CRN. Please try again.");
                return;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        List<Course> empty = new ArrayList<Course>();
        courseTable.setItems(FXCollections.observableList(empty));
        if (Admin.RemoveStudentFromCourse(studentInput, crnInput)) {
            resultMsg.setText("Student successfully removed from course.");
        }
        else {
            resultMsg.setText("Student was not found under selected course.");
        }

        courseTable.setItems(FXCollections.observableList(User.GetAllCourses()));
    }
}
