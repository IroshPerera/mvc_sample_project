package lk.ijse.mvc_sample_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.mvc_sample_project.model.UserModel;

public class UserPageFormController {
    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserID;

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

        String userId = txtUserID.getText();
        String password = txtPassword.getText();

        boolean isAdded = UserModel.addUser(userId, password);

        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION, "User Added Successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "User Added Failed").show();
        }

    }

}
