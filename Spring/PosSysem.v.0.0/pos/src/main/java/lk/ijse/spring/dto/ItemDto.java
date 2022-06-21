package lk.ijse.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ItemDto {
    private String itemCode;
    private String itemName;
    private double unitPrice;
    private double buyingPrice;
    private String packSize;
    private double quantity;




}
