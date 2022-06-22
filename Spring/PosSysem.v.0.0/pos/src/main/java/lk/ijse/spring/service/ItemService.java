package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemDto;

import java.util.List;

public interface ItemService {

    public List<ItemDto> getAllItems();
    public void saveItem(ItemDto itemDto);
    public void updateItem(ItemDto ItemDto);
    public void deleteItem(String id);
    public  ItemDto searchItem(String id);
    public List<String> getAllIds();







}
