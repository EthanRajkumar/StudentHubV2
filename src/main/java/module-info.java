module com.example.studenthublogin {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.studenthublogin to javafx.fxml;
    exports com.example.studenthublogin;
}