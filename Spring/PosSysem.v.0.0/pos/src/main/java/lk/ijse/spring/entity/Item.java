package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Item {

    @Id
    private String itemCode;
    private String itemName;
    private  double unitPrice;
    private  double buyingPrice;
    private  String packSize;
    private  double quantity;




}
