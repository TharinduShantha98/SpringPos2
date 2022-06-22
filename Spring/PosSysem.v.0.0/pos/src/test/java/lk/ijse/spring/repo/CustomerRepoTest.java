package lk.ijse.spring.repo;

import lk.ijse.spring.config.JpaConfig;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {JpaConfig.class})
@ExtendWith(SpringExtension.class)

class CustomerRepoTest {


    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void getAllCustomerId(){
        List<String> allByCustomerId =
                customerRepo.getAllCustomerIds();

        for (String c1: allByCustomerId
             ) {
            System.out.println(c1);

        }


    }



}