package lk.ijse.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderDetailDto {
    private String orderId;
    private String itemCode;
    private double saleQty;
    private double saleItemPrice;
    private double profit;




}
