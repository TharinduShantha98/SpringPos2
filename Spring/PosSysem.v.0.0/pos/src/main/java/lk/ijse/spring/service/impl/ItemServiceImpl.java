package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemDto;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl  implements ItemService {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<ItemDto> getAllItems() {
        List<Item> all = itemRepo.findAll();
        List<ItemDto> itemDtoList  =  new ArrayList<>();

        for (Item I1: all
        ) {

            itemDtoList.add(modelMapper.map(I1,ItemDto.class));
        }

        return itemDtoList;
    }

    @Override
    public void saveItem(ItemDto itemDto) {
        if (!itemRepo.existsById(itemDto.getItemCode())) {
            itemRepo.save(modelMapper.map(itemDto, Item.class));
        }else{
            throw  new RuntimeException("item is already exists");
        }


    }

    @Override
    public void updateItem(ItemDto itemDto) {
        if(itemRepo.existsById(itemDto.getItemCode())){
            itemRepo.save(modelMapper.map(itemDto,Item.class));
        }else{
            throw new RuntimeException("this is item can not found");
        }

    }

    @Override
    public void deleteItem(String id) {
        if(itemRepo.existsById(id)){
            itemRepo.deleteById(id);
        }else{
            throw  new RuntimeException("this is item can not found");
        }

    }

    @Override
    public ItemDto searchItem(String id) {
        if (itemRepo.existsById(id)) {
            Optional<Item> byId = itemRepo.findById(id);
            return modelMapper.map(byId, ItemDto.class);
        }else {
            throw new RuntimeException("this is item can not found");
        }
    }

    @Override
    public List<String> getAllIds() {
        return itemRepo.getAllItemsIds();
    }
}
