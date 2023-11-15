package lk.ijse.mvc_sample_project.model;

import lk.ijse.mvc_sample_project.db.DBConnection;
import lk.ijse.mvc_sample_project.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel {



    public static boolean addUser(UserDTO userDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO user VALUES (?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,userDTO.getUser_ID());
        pstm.setObject(2,userDTO.getPassword());
        return pstm.executeUpdate()>0;
    }

    public static boolean validateUser(UserDTO userDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user WHERE user_id=? AND password=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1,userDTO.getUser_ID());
            pstm.setObject(2,userDTO.getPassword());
            return pstm.executeQuery().next();

    }
}
