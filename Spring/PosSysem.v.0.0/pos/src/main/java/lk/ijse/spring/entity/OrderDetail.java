package lk.ijse.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@IdClass(OrderDetail_Pk.class)
public class OrderDetail {


    @Id
    private String orderId;
    @Id
    private String itemCode;
    private double saleQty;
    private double saleItemPrice;
    private double profit;


    @ManyToOne

    @JoinColumn(name = "orderId",referencedColumnName = "orderId",insertable = false,updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "itemCode",insertable = false, updatable = false)
    private  Item item;





}
