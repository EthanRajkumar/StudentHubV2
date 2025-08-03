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
import java.util.Objects;

public class StudentRemoveCourseController extends SceneController {

    @FXML
    private VBox studentRemoveCourseVBox;

    @FXML
    private Label studentRemoveCourseResult;

    @FXML
    private TextField studentRemoveCourseInput;

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
        courseTable.setItems(FXCollections.observableList(Globals.Student.GetSchedule()));
    }

    @FXML
    protected void onStudentReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubStudentMenu.fxml");
    }

    @FXML
    protected void onStudentEnterRemoveCourse() throws IOException {
        studentRemoveCourseResult.setText(Globals.Student.RemoveClass(studentRemoveCourseInput.getText()));
        courseTable.setItems(FXCollections.observableList(Globals.Student.GetSchedule()));
    }

}
