package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;



    @GetMapping
    public void getAllCustomer(){
        System.out.println("project is work");

    }


    @PostMapping()
    public  void uploadCustomerDetail(@ModelAttribute CustomerDTO customerDTO) throws IOException, SQLException {
        System.out.println("hello post");

        System.out.println(customerDTO.getPImage());

        /*MultipartFile pImage = customerDTO.getPImage();
        byte[] bytes = pImage.getBytes();
        SerialBlob serialBlob = new SerialBlob(bytes);
        System.out.println(serialBlob);*/



       /* for (int i =0; i < bytes.length;i++){
            System.out.println(bytes[i]);

        }
*/


        if(!customerDTO.getPImage().isEmpty()){
           customerService.saveCustomer(customerDTO);


        }



    }


}
