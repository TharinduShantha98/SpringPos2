package lk.ijse.spring.repo;

import lk.ijse.spring.config.JpaConfig;
import lk.ijse.spring.entity.Order;
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

class OrderRepoTest {

    @Autowired
    OrderRepo orderRepo;



    @Test
    void findTopByOrderByOrderIdDesc() {
    }

    @Test
    void findOrderByCustomerId() {

        List<Order> all =
                orderRepo.findAll();


        for (Order o1:all
             ) {
            System.out.println(o1);

        }

        /*String orderByCustomerId = orderRepo.findOrderByCustomerId("O-100");
        System.out.println(orderByCustomerId);*/



    }
}