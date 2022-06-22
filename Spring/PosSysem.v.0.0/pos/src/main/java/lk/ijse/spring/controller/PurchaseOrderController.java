package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.dto.OrderDto;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
@CrossOrigin

public class PurchaseOrderController  {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @Autowired
    ItemService itemService;

    @Autowired
    CustomerService customerService;


    @PutMapping
    public RestController purchaseOrder(OrderDto orderDto){
        return null;


    }


    @GetMapping
    public void getAllCustomerIds(){


    }



}
