package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseUtil uploadCustomerDetail(@ModelAttribute CustomerDTO customerDTO) throws IOException, SQLException {
        System.out.println("hello post");

        System.out.println(customerDTO.getPImage());

        if(!customerDTO.getPImage().isEmpty()){
           customerService.saveCustomer(customerDTO);
           return new ResponseUtil(200,"customer added successful",null);
        }
        return new ResponseUtil(400,"not add image",null);

    }



    @GetMapping(path = "search", params = "id")
    public ResponseUtil searchCustomer(@RequestParam String id){
        System.out.println("hiiiiii");
        Customer customer = customerService.searchCustomer(id);
        return  new ResponseUtil(200, "get Successfully", customer);

    }


}
