package lk.ijse.mvc_sample_project.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.mvc_sample_project.dto.UserDTO;
import lk.ijse.mvc_sample_project.model.UserModel;

import java.io.IOException;
import java.sql.SQLException;

public class UserPageFormController {


    public AnchorPane root;
    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserID;

    @FXML
    void btnLoginOnAction(ActionEvent event) {


    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        String user_ID = txtUserID.getText();
        String password = txtPassword.getText();

        UserDTO userDTO = new UserDTO(user_ID, password);

        boolean isAdded = false;
        try {
            isAdded = UserModel.addUser(userDTO);


            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "User Added Successfully");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "User Added Failed");
                alert.show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    @FXML
    public void btnBackOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/login_page_form.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
