package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrderDto;
import lk.ijse.spring.entity.Order;
import lk.ijse.spring.entity.OrderDetail;
import lk.ijse.spring.repo.OrderDetailRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PurchaseOrderServiceImpl  implements PurchaseOrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Autowired
    ModelMapper modelMapper;





    @Override
    public void purchaseOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);

        if (!orderRepo.existsById(orderDto.getOrderId())) {
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
