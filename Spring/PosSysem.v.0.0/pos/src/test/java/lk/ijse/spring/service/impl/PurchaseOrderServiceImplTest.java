package lk.ijse.spring.service.impl;



import lk.ijse.spring.config.JpaConfig;
import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.dto.OrderDetailDto;
import lk.ijse.spring.dto.OrderDto;
import lk.ijse.spring.entity.Order;
import lk.ijse.spring.entity.OrderDetail;
import lk.ijse.spring.repo.OrderDetailRepo;
import lk.ijse.spring.repo.OrderRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class,JpaConfig.class})
@ExtendWith(SpringExtension.class)

class PurchaseOrderServiceImplTest {



    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Autowired
    ModelMapper modelMapper;





    @Test
    public void purchaseOrder() {



        CustomerDto c1 = new CustomerDto("C00-003","methmii","pabasara","rathnapura","meth@gmail.com","0701936879");

        ArrayList<OrderDetailDto> orderDetail = new ArrayList<>();
        orderDetail.add(new OrderDetailDto("O-001","I001",2,460,30));

        OrderDto o1 = new OrderDto("O-001",460,30,"12345",c1,orderDetail);

        Order order = modelMapper.map(o1, Order.class);


            if (!orderRepo.existsById(o1.getOrderId())) {
                orderRepo.save(order);

                if(order.getOrderDetailList().size()<1){
                    throw  new RuntimeException("No item added this order");

                }

                for (OrderDetail orderDetails : order.getOrderDetailList()
                ) {


                }

            }

    }

}