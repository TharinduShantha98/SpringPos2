package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @GetMapping
    public void getAllCustomer(){
        System.out.println("project is work");

    }


    @PostMapping()
    public  void uploadCustomerDetail(@ModelAttribute CustomerDTO customerDTO){
        System.out.println("hello post");

        System.out.println(customerDTO.getPImage());
        //System.out.println(multipartFile);




    }


}
