package lk.ijse.mvc_sample_project.dto;

public class UserDTO {
    private String user_ID;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String user_ID, String password) {
        this.user_ID = user_ID;
        this.password = password;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
