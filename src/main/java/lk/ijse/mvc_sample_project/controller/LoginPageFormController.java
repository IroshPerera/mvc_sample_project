package lk.ijse.mvc_sample_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.mvc_sample_project.dto.UserDTO;
import lk.ijse.mvc_sample_project.model.UserModel;

import java.io.IOException;
import java.sql.SQLException;

public class LoginPageFormController {


    @FXML
    public AnchorPane root;
    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserID;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

        String user_id = txtUserID.getText();
        String password = txtPassword.getText();

        UserDTO userDTO = new UserDTO(user_id, password);

        boolean isValid = false;
        try {
            isValid = UserModel.validateUser(userDTO);


        if (isValid) {
            try {
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_page_form.fxml"));
                Scene scene = new Scene(anchorPane);
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Invalid");
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user_page_form.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
