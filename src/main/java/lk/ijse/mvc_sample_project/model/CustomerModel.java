package lk.ijse.mvc_sample_project.model;

import lk.ijse.mvc_sample_project.db.DBConnection;
import lk.ijse.mvc_sample_project.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {


    public static boolean addCustomer(CustomerDTO customerDTO) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO customer(customer_id,name,address,contact) VALUES(?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, customerDTO.getCustomer_id());
        pstm.setString(2, customerDTO.getName());
        pstm.setString(3, customerDTO.getAddress());
        pstm.setString(4, customerDTO.getContact());

        /* int index = pstm.executeUpdate();*/

      /*  if (index>0){
            return true;
        }else{
            return false;
        }*/

        /*  return index>0;*/

        return pstm.executeUpdate() > 0;

    }

    public static List<CustomerDTO> getAll() throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        List<CustomerDTO> customerDTOS  = new ArrayList<>();

        while(resultSet.next()){

            String customer_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String contact = resultSet.getString(4);

            CustomerDTO customerDTO = new CustomerDTO(customer_id, name, address, contact);
            customerDTOS.add(customerDTO);

        }

        return customerDTOS;

    }
}
