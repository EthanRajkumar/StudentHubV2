package com.example.studenthublogin;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class InstructorSearchCourseRosterController extends SceneController {

    @FXML
    private VBox instructorSearchCourseRosterVBox;

    @FXML
    private TextField searchCourseID, searchFirstName, searchLastName;

    @FXML
    private TableView courseTable, studentTable;

    @FXML
    private TableColumn courseTableCourseID, courseTableCourseName, courseTableTime, courseTableDays, courseTableSemesters, courseTableYear, courseTableSeats, courseTableRoster;

    @FXML
    private TableColumn studentName, studentID, studentEmail, studentMajor, studentYear;

    @Override
    public void Initialize(Stage stage)
    {
        courseTable.setEditable(true);
        courseTableCourseID.setCellValueFactory(new PropertyValueFactory<Course, Integer>("CRN"));
        courseTableCourseName.setCellValueFactory(new PropertyValueFactory<Course, String>("Title"));
        courseTableTime.setCellValueFactory(new PropertyValueFactory<Course, Integer>("Time"));
        courseTableDays.setCellValueFactory(new PropertyValueFactory<Course, String>("DaysString"));
        courseTableSemesters.setCellValueFactory(new PropertyValueFactory<Course, String>("SemestersString"));
        courseTableYear.setCellValueFactory(new PropertyValueFactory<Course, Integer>("Year"));
        courseTableSeats.setCellValueFactory(new PropertyValueFactory<Course, Integer>("Seats"));
        courseTableRoster.setCellValueFactory(new PropertyValueFactory<Course, String>("StudentIDsString"));

        studentTable.setEditable(true);
        studentName.setCellValueFactory(new PropertyValueFactory<Student, String>("FullName"));
        studentID.setCellValueFactory(new PropertyValueFactory<Student, String>("ID"));
        studentEmail.setCellValueFactory(new PropertyValueFactory<Student, String>("Email"));
        studentMajor.setCellValueFactory(new PropertyValueFactory<Student, String>("Major"));
        studentYear.setCellValueFactory(new PropertyValueFactory<Student, Integer>("GradYear"));
    }

    @FXML
    protected void onInstructorReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubInstructorMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourseID() throws IOException {
        int crn_input = -1;

        try { crn_input = Integer.parseInt(searchCourseID.getText()); }
        catch (Exception e) { System.out.println(e); }

        List<Course> courses = Globals.Instructor.GetCourseRoster(crn_input);
        courseTable.setItems(FXCollections.observableList(courses));
    }

    @FXML
    protected void onUserEnterSearchName() throws IOException {
        int crn_input = -1;

        try { crn_input = Integer.parseInt(searchCourseID.getText()); }
        catch (Exception e) { System.out.println(e); }

        List<Student> students = Globals.Instructor.SearchCourseRoster(crn_input, searchFirstName.getText(), searchLastName.getText());
        studentTable.setItems(FXCollections.observableList(students));
    }

}
