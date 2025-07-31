package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AdminSearchCourseAdvController {

    @FXML
    private VBox searchCourseAdvVBox;

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        new SceneSwitch(searchCourseAdvVBox, "StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourseAdv() throws IOException {

    }

}
