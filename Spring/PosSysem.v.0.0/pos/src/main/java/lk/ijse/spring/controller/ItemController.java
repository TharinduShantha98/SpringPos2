package lk.ijse.spring.controller;


import lk.ijse.spring.dto.ItemDto;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
@CrossOrigin

public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping
    public ResponseUtil getAllItems(){
        List<ItemDto> allItems = itemService.getAllItems();
        return new ResponseUtil(200,"Successful getAll Items",allItems);


    }

    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDto itemDto){
        itemService.saveItem(itemDto);
        return  new ResponseUtil(200, "Successful added", null);
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDto itemDto){
        itemService.updateItem(itemDto);
        return new ResponseUtil(200,"successFully update ",null);


    }

    @GetMapping(path = "search", params = "id")
    public ResponseUtil searchItem(@RequestParam String id){
        ItemDto itemDto = itemService.searchItem(id);
        System.out.println(itemDto.toString());
        return new ResponseUtil(200, "successfully search ",itemDto);

    }


    @DeleteMapping(params = "id")
    public ResponseUtil deleteItem(@RequestParam String id){
        itemService.deleteItem(id);
        return new ResponseUtil(200, "successfully delete ",null);
    }











}
