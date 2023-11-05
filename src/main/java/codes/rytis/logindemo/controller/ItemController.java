package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.item.ItemDto;
import codes.rytis.logindemo.dto.item.ItemSaveDto;
import codes.rytis.logindemo.dto.item.ItemUpdateDto;
import codes.rytis.logindemo.service.ItemService;
import codes.rytis.logindemo.utils.DataTypeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {
    private final ItemService service;
    @GetMapping("/items")
    public ResponseEntity<?> getItemsByIgId(@RequestParam(name = "igId") String igId){
        return service.getItemsByIgId(DataTypeUtils.ConvertStringToInt(igId));
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveItem(@RequestBody ItemSaveDto itemSaveDto){
        return service.saveItem(itemSaveDto);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteItem(@RequestParam("itemId") String itemId){
        return service.deleteItem(DataTypeUtils.ConvertStringToInt(itemId));
    }
    @PatchMapping("/discount")
    public ResponseEntity<?> updateDiscountItem(@RequestParam("itemId") String itemId ,@RequestBody ItemUpdateDto itemUpdateDto){
        return service.updateDiscountItem(DataTypeUtils.ConvertStringToInt(itemId),itemUpdateDto);
    }
    @PatchMapping("/name")
    public ResponseEntity<?> updateNameItem(@RequestParam("itemId") String itemId ,@RequestBody ItemUpdateDto itemUpdateDto){
        return service.updateNameItem(DataTypeUtils.ConvertStringToInt(itemId),itemUpdateDto);
    }
    @PatchMapping("/description")
    public ResponseEntity<?> updateDescriptionItem(@RequestParam("itemId") String itemId ,@RequestBody ItemUpdateDto itemUpdateDto){
        return service.updateDescriptionItem(DataTypeUtils.ConvertStringToInt(itemId),itemUpdateDto);
    }
}
