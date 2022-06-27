package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.BASE64DecodedMultipartFile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;



@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerServiceImplTest {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    void saveCustomer() {



    }

    @Test
    void searchCustomer() {
       /* Optional<Customer> byId = customerRepo.findById("C00-005");
        Customer customer = byId.get();
        System.out.println(customer);
        byte[] pImage = customer.getPImage();*/




    }
}