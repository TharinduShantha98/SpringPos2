package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String LastName;
    private String Address;
    private String telNo;
    private String Email;
    @Lob
    @Column(name = "photo", columnDefinition = "BLOB")
    private MultipartFile files;

    









}
