package lk.ijse.mvc_sample_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.mvc_sample_project.dto.CustomerDTO;
import lk.ijse.mvc_sample_project.model.CustomerModel;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerPageFormController {
    public AnchorPane root;
    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colCustID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<?> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtCustID;

    @FXML
    private TextField txtName;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/view/dashboard_page_form.fxml"));
            Scene scene = new Scene(parent);


            Stage stage = (Stage) root.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        String cust_id = txtCustID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();


        CustomerDTO customerDTO = new CustomerDTO(cust_id, name, address, contact);


        try {
           boolean isSaved = CustomerModel.addCustomer(customerDTO);


        if (isSaved){

            clearData();
            new Alert(Alert.AlertType.CONFIRMATION,"Customer successfully saved !!!").show();

        }else {

            new Alert(Alert.AlertType.ERROR,"Customer successfully not saved !!!").show();

        }

        } catch (SQLException e) {
           /* throw new RuntimeException(e);*/
            new Alert(Alert.AlertType.ERROR,"Customer ID already exist !!!").show();
        }



    }

    private void clearData() {
        txtCustID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtContact.setText("");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }
}
