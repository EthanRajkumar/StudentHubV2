package com.example.studenthublogin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminSearchCourseController extends SceneController {

    @FXML
    private TableView courseTable;

    @FXML
    private TextField searchCourseInput;

    @FXML
    private VBox searchCourseVBox;

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
    }

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourse() throws IOException {
        ObservableList<Course> courses = FXCollections.observableList(User.SearchCoursebyDept(searchCourseInput.getText()));

        courseTable.setItems(courses);
    }


}
