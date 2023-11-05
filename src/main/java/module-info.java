module lk.ijse.mvc_sample_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.ijse.mvc_sample_project to javafx.fxml;
    exports lk.ijse.mvc_sample_project;
}