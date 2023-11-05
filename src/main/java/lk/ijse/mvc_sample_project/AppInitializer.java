package lk.ijse.mvc_sample_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/user_page_form.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("User Page");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
