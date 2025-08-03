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

public class InstructorShowCourseRosterController extends SceneController {

    @FXML
    private VBox instructorShowCourseRosterVBox;

    @FXML
    private TextField searchCourseID;

    @FXML
    private TableView courseTable;

    @FXML
    private TableColumn courseTableCourseID, courseTableCourseName, courseTableTime, courseTableDays, courseTableSemesters, courseTableYear, courseTableSeats, courseTableRoster;

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
}
