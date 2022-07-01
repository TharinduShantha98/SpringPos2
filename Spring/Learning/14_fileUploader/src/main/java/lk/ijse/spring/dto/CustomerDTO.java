package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {

    private String customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String telNo;
    private String email;
    //private byte[] pImage;
    private MultipartFile pImage;








}
