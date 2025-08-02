package com.example.studenthublogin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwapper {
    public static Stage stage;

    public static SceneController GetController(String sceneUrl, FXMLLoader loader)
    {
        switch (sceneUrl)
        {
            case "hello-view.fxml":
                return loader.<HelloController>getController();

            case "StudentHubAdminAddCourse.fxml":
                return loader.<StudentAddCourseController>getController();

            case "StudentHubAdminMenu.fxml":
                return loader.<StudentMenuController>getController();

            case "StudentHubAdminRemoveCourse.fxml":
                return loader.<AdminRemoveCourseController>getController();

            case "StudentHubAdminSearchCourse.fxml":
                return loader.<StudentSearchCourseController>getController();

            case "StudentHubAdminSearchCourseAdv.fxml":
                return loader.<StudentSearchCourseAdvController>getController();

            case "StudentHubAdminLinkInstructor.fxml":
                return loader.<AdminLinkInstructorController>getController();

            case "StudentHubAdminUnlinkInstructor.fxml":
                return loader.<AdminUnlinkInstructorController>getController();

            case "StudentHubAdminRegisterStudent.fxml":
                return loader.<AdminRegisterStudentController>getController();

            case "StudentHubAdminUnregisterStudent.fxml":
                return loader.<AdminUnregisterStudentController>getController();

            case "StudentHubInstructorMenu.fxml":
                return loader.<InstructorMenuController>getController();

            case "StudentHubInstructorSearchCourse.fxml":
                return loader.<InstructorSearchCourseController>getController();

            case "StudentHubInstructorSearchCourseAdv.fxml":
                return loader.<InstructorSearchCourseAdvController>getController();

            case "StudentHubInstructorSearchCourseRoster.fxml":
                return loader.<InstructorShowCourseRosterController>getController();

            case "StudentHubInstructorShowCourseRoster.fxml":
                return loader.<InstructorShowCourseRosterController>getController();

            case "StudentHubInstructorShowSchedule.fxml":
                return loader.<InstructorShowScheduleController>getController();

            case "StudentHubLogin.fxml":
                return loader.<HelloController>getController();

            case "StudentHubStudentAddCourse.fxml":
                return loader.<StudentAddCourseController>getController();

            case "StudentHubStudentMenu.fxml":
                return loader.<StudentMenuController>getController();

            case "StudentHubStudentRemoveCourse.fxml":
                return loader.<StudentRemoveCourseController>getController();

            case "StudentHubStudentSearchCourse.fxml":
                return loader.<StudentSearchCourseController>getController();

            case "StudentHubStudentSearchCourseAdv.fxml":
                return loader.<StudentSearchCourseAdvController>getController();

            case "StudentHubStudentShowSchedule.fxml":
                return loader.<StudentShowScheduleController>getController();
        }

        return null;
    }

    public static void SwapScene(String sceneUrl)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(sceneUrl));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 640, 400);
            stage.setScene(scene);
            SceneController controller = GetController(sceneUrl, fxmlLoader);
            controller.Initialize(stage);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
