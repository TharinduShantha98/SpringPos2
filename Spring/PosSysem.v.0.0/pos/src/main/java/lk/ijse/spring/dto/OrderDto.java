package lk.ijse.spring.dto;

import lk.ijse.spring.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@NoArgsConstructor
@Data
@ToString
public class OrderDto {
    private  String orderId;
    private  double totalPrice;
    private  double profit;
    private String dataAndTime;

    private CustomerDto customerDto;
    private List<OrderDetailDto> orderDetailLists;

    public OrderDto(String orderId, double totalPrice, double profit, String dataAndTime,
                    CustomerDto customerDto, List<OrderDetailDto> orderDetailLists) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.profit = profit;
        this.dataAndTime = dataAndTime;
        this.customerDto = customerDto;
        this.orderDetailLists = orderDetailLists;
    }
}
