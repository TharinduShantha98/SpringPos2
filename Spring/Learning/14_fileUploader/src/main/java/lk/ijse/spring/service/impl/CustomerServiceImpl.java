package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.BASE64DecodedMultipartFile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;


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
            MultipartFile file = customerDTO.getPImage();
            Customer customer = new Customer();
            customer.setCustomerId(customerDTO.getCustomerId());
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            customer.setAddress(customerDTO.getAddress());
            customer.setEmail(customerDTO.getEmail());
            customer.setTelNo(customerDTO.getTelNo());

            try {
                byte[] bytes = file.getBytes();
                System.out.println(Arrays.toString(file.getBytes()));
                System.out.println(file.getContentType());
                System.out.println(file.getName());
                System.out.println(file.getOriginalFilename());
                System.out.println(file.getInputStream());


                customer.setPImage(bytes);
                customer.setFileName(file.getOriginalFilename());
                customer.setFileType(file.getContentType());


            } catch (IOException e) {
                e.printStackTrace();
            }
            customerRepo.save(customer);
        }else{
            throw new RuntimeException("this customer already exist");

        }
    }

    @Override
    public Customer searchCustomer(String id) {

        Optional<Customer> byId = customerRepo.findById(id);
        Customer customer = byId.get();
//      byte[] pImage = customer.getPImage();

        return customer;

    }
}
