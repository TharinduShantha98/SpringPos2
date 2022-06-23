package lk.ijse.spring.service;

import lk.ijse.spring.dto.OrderDto;

import java.util.List;

public interface PurchaseOrderService {

    public void purchaseOrder(OrderDto orderDto);
    public String createOrderId();
    public List<OrderDto> getAllOrders();


}
