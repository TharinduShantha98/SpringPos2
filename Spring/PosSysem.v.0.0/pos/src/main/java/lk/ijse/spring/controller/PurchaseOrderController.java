package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.dto.OrderDto;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.service.PurchaseOrderService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
@CrossOrigin
public class PurchaseOrderController  {

    @Autowired
    PurchaseOrderService purchaseOrderService;


    @PostMapping
    public ResponseUtil purchaseOrder(@RequestBody OrderDto orderDto){
        System.out.println("Post mapping");

        System.out.println(orderDto.toString());

        purchaseOrderService.purchaseOrder(orderDto);
        return new ResponseUtil(200,"Successfully purchaseOrder",null);


    }





}
