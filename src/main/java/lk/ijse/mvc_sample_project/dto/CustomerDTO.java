package lk.ijse.mvc_sample_project.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
/*@Getter
@Setter
@ToString*/
@Data
public class CustomerDTO {
    private String customer_id;
    private String name;
    private String address;
    private String contact;
}
