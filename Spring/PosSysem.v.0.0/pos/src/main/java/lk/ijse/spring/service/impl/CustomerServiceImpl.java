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


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ModelMapper modelMapper;



    @Override
    public void saveCustomer(CustomerDto customerDto) {

    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {

    }

    @Override
    public Customer searchCustomer(String id) {
        return null;
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
