package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomer(){
        System.out.println("Hello");
        List<CustomerDto> allCustomer = customerService.getAllCustomer();
        return new ResponseUtil(200,"successFul",allCustomer);

    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDto customerDto){
        customerService.saveCustomer(customerDto);
        return new ResponseUtil(200,"SuccessFul",null);



    }

    @DeleteMapping(params = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseUtil deleteCustomer(@RequestParam String id){
        //System.out.println(id);
        customerService.deleteCustomer(id);
        return new ResponseUtil(200,"SuccessFul",null);


    }


    @GetMapping(path = "search", params = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@RequestParam String id){
        // System.out.println("this is search part");

        Customer customer = customerService.searchCustomer(id);
        return new ResponseUtil(200,"SuccessFul",customer);


    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerDto);
        return new ResponseUtil(200,"SuccessFul",null);

    }

    @GetMapping(path = "getIds")
    public ResponseUtil getAllCustomerIds(){
        System.out.println("get all customer ids");

        List<String> allCustomerIds = customerService.getAllCustomerIds();
        return new ResponseUtil(200,"SuccessFul",allCustomerIds);

    }




}
