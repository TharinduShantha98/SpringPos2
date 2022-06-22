package lk.ijse.spring.dto;

import lk.ijse.spring.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderDto {
    private  String orderId;
    private  String customerId;
    private  double totalPrice;
    private  double profit;
    private String dataAndTime;

    private CustomerDto customerDto;
    private List<OrderDetail> orderDetailList;




}
