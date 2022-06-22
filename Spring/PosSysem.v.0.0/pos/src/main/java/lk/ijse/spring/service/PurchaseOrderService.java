package lk.ijse.spring.service;

import lk.ijse.spring.dto.OrderDto;

public interface PurchaseOrderService {

    public void purchaseOrder(OrderDto orderDto);
    public String createOrderId();
}
