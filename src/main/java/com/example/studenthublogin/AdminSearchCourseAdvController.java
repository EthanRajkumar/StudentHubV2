package com.example.studenthublogin;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AdminSearchCourseAdvController extends SceneController {

    @FXML
    private VBox searchCourseAdvVBox;

    @FXML
    protected void onAdminReturnToMenuPress() throws IOException {
        SceneSwapper.SwapScene("StudentHubAdminMenu.fxml");
    }

    @FXML
    protected void onUserEnterSearchCourseAdv() throws IOException {

    }

}
