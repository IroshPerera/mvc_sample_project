package lk.ijse.mvc_sample_project.dto.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerTM {
    private String customer_id;
    private String name;
    private String address;
    private String contact;

}
