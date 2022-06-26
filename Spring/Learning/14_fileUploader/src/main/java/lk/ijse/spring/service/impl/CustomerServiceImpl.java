package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CustomerRepo customerRepo;


    @Override
    public void saveCustomer(CustomerDTO customerDTO) {

        if(!customerRepo.existsById(customerDTO.getCustomerId())){
            //customerRepo.save(modelMapper.map(customerDTO,Customer.class));


            MultipartFile pImage = customerDTO.getPImage();
            Customer customer = new Customer();
            customer.setCustomerId(customerDTO.getCustomerId());
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            customer.setAddress(customerDTO.getAddress());
            customer.setEmail(customerDTO.getEmail());
            customer.setTelNo(customerDTO.getTelNo());


            try {
                byte[] bytes = pImage.getBytes();
                customer.setPImage(bytes);




            } catch (IOException e) {
                e.printStackTrace();
            }

            customerRepo.save(customer);
            //customerRepo.save(modelMapper.map(customerDTO, Customer.class));

        }else{
            throw new RuntimeException("this customer already exist");

        }
    }
}
