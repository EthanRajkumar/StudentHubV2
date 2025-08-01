package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminMenuController extends SceneController {

    @FXML
    private VBox adminMenuVBox;

    @FXML
    protected void onAdminSelectLogout() throws IOException {
        SceneSwapper.SwapScene("StudentHubLogin.fxml");
    }

    @FXML
    protected void onAdminSelectUnregisterStudent() throws IOException {
        //SceneSwapper.SwapScene("StudentHubAdmin.fxml");
    }

    @FXML
    protected void onAdminSelectCourseSearch() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminSearchCourse.fxml");
    }

    @FXML
    protected void onAdminSelectAdvCourseSearch() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminSearchCourseAdv.fxml");
    }

    @FXML
    protected void onAdminSelectAddCourse() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminAddCourse.fxml");
    }

    @FXML
    protected void onAdminSelectRemoveCourse() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminRemoveCourse.fxml");
    }

    @FXML
    protected void onAdminSelectAddUser() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminAddUser.fxml");
    }

    @FXML
    protected void onAdminSelectLinkInstructor() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminLinkInstructor.fxml");
    }

    @FXML
    protected void onAdminSelectUnlinkInstructor() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminUnlinkInstructor.fxml");
    }

    @FXML
    protected void onAdminSelectRegisterStudent() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminUnregisterStudent.fxml");
    }

}
