package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.entity.Customer;

import java.util.List;

public interface CustomerService {
    public  void saveCustomer(CustomerDto customerDto);

    public  void deleteCustomer(String id);

    public void updateCustomer(CustomerDto customerDto);

    public Customer searchCustomer(String id);

    public List<CustomerDto> getAllCustomer();
}
