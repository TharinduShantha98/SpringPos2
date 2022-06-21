package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ModelMapper modelMapper;



    @Override
    public void saveCustomer(CustomerDto customerDto) {
        Customer map = modelMapper.map(customerDto, Customer.class);

        if (!customerRepo.existsById(map.getCustomerId())) {
            customerRepo.save(map);
        }else {
            throw  new RuntimeException("customer Already exists...!");
        }

    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);

        }else{
            throw new RuntimeException("Customer not found");
        }

    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);



        if(customerRepo.existsById(customer.getCustomerId())){
            customerRepo.save(customer);
        }else{
            throw new RuntimeException("Customer not found for update customer");
        }

    }

    @Override
    public Customer searchCustomer(String id) {
        if(customerRepo.existsById(id)){
            Optional<Customer> byId = customerRepo.findById(id);

            return byId.get();
        }else{
            throw new RuntimeException("Customer not found for search customer");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer c: all
        ) {
            CustomerDto map = modelMapper.map(c, CustomerDto.class);
            customerDtoList.add(map);
        }

        return customerDtoList;
    }
}
