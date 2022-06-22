package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrderDto;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.Order;
import lk.ijse.spring.entity.OrderDetail;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderDetailRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PurchaseOrderServiceImpl  implements PurchaseOrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Autowired
    ItemRepo itemRepo;


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
                Item item = orderDetails.getItem();
                System.out.println(item.getItemCode());


                if(itemRepo.existsById(item.getItemCode())){
                    Optional<Item> byId = itemRepo.findById(item.getItemCode());
                    Item item1 = byId.get();
                    double quantity = item1.getQuantity();
                    item1.setQuantity(quantity-orderDetails.getSaleQty());
                    //System.out.println(item1.toString());
                    itemRepo.save(item1);


                }


            }

        }

    }

    @Override
    public String createOrderId() {
        Order topByOrderByOrderIdDesc = orderRepo.findTopByOrderByOrderIdDesc();
        if(topByOrderByOrderIdDesc == null){
            return "O-100";
        }else{
            int tempId  = Integer.parseInt(topByOrderByOrderIdDesc.getOrderId().split("-")[1]);
            tempId =  tempId+ 1;
            return "O-"+tempId;


        }




    }
}
