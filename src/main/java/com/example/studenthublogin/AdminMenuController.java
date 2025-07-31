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

public class AdminMenuController {

    @FXML
    private VBox adminMenuVBox;

    @FXML
    protected void onAdminSelectCourseSearch() throws IOException {
        new SceneSwitch(adminMenuVBox, "StudentHubAdminSearchCourse.fxml");
    }

    @FXML
    protected void onAdminSelectAdvCourseSearch() throws IOException {
        new SceneSwitch(adminMenuVBox, "StudentHubAdminSearchCourseAdv.fxml");
    }

    @FXML
    protected void onAdminSelectAddCourse() throws IOException {
        new SceneSwitch(adminMenuVBox, "StudentHubAdminAddCourse.fxml");
    }

    @FXML
    protected void onAdminSelectRemoveCourse() throws IOException {
        new SceneSwitch(adminMenuVBox, "StudentHubAdminRemoveCourse.fxml");
    }

    @FXML
    protected void onAdminSelectAddUser() throws IOException {
        new SceneSwitch(adminMenuVBox, "StudentHubAdminAddUser.fxml");
    }

    @FXML
    protected void onAdminSelectLinkInstructor() throws IOException {
        new SceneSwitch(adminMenuVBox, "StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onAdminSelectUnlinkInstructor() throws IOException {
        new SceneSwitch(adminMenuVBox, "StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onAdminSelectRegisterStudent() throws IOException {
        new SceneSwitch(adminMenuVBox, "StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onAdminSelectUnregisterStudent() throws IOException {
        new SceneSwitch(adminMenuVBox, "StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onAdminSelectLogout() throws IOException {
        new SceneSwitch(adminMenuVBox, "StudentHubLogin.fxml");
    }
}
