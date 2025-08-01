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
import java.util.List;

public class StudentSearchCourseAdvController extends SceneController {

    @FXML
    private VBox searchCourseAdvVBox;

    @FXML
    private TableView courseTable;

    @FXML
    private TextField searchCourseName, searchCourseDept, searchCourseYear, searchCourseID, searchCourseSemester;

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
    protected void onStudentReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubStudentMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourseAdv() throws IOException {
        int id_input = -1, year_input = -1;

        try { id_input = Integer.parseInt(searchCourseID.getText()); }
        catch (Exception e) { System.out.println(e); }

        try { year_input = Integer.parseInt(searchCourseYear.getText()); }
        catch (Exception e) { System.out.println(e); }

        List<Course> courseList = User.SearchCourseByParam(id_input, searchCourseName.getText(), searchCourseDept.getText(), searchCourseSemester.getText(), year_input);
        ObservableList<Course> courses = FXCollections.observableList(courseList);

        courseTable.setItems(courses);
    }

}
