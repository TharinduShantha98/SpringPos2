package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin

public class PurchaseOrderController  {




    @PutMapping
    public RestController purchaseOrder(CustomerDto customerDto){
        return null;


    }



}
