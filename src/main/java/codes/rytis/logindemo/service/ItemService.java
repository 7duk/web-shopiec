package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.item.ItemDto;
import codes.rytis.logindemo.dto.item.ItemIdDto;
import codes.rytis.logindemo.dto.item.ItemSaveDto;
import codes.rytis.logindemo.dto.item.ItemUpdateDto;
import codes.rytis.logindemo.dto.itemdetail.ItemDetailDto;
import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.entity.Item;
import codes.rytis.logindemo.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ItemService {
    private final ItemRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<List<ItemDto>> getItemsByIgId(Integer igId) {
        List<Item> items = repository.getItemsByIgIdAndIsDelete(igId, 0);
        List<ItemDto> itemDtos = items.stream().map(e -> {
            ItemDto itemDto = mapper.map(e, ItemDto.class);
            itemDto.setItemDetails(e.getItemDetails().stream().map(i->{
                ItemDetailDto itemDetailDto = mapper.map(i, ItemDetailDto.class);
                itemDetailDto.setColorId(i.getColorId());
                return itemDetailDto;
            }).toList());
            return itemDto;
        }).toList();
        return new ResponseEntity<>(itemDtos, HttpStatus.OK);
    }

    public ResponseEntity<?> saveItem(ItemSaveDto itemSaveDto) {
        System.out.println(itemSaveDto.toString());
        Item item = mapper.map(itemSaveDto, Item.class);
        item.setLastUpdateAt(LocalDateTime.parse(itemSaveDto.getLastUpdateAt(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(item.toString());
        try {
            repository.saveItem(item);
            return new ResponseEntity<>(Response.builder().message("SUCCESS").build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Response.builder().message(e.getMessage()).build(), HttpStatus.FOUND);
        }
    }
    public ResponseEntity<?> deleteItem(Integer itemId){
        if(repository.deleteItem(itemId)==1){
            return new ResponseEntity<>(Response.builder().message("SUCCESS").build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(Response.builder().message("ERROR"), HttpStatus.FOUND);
    }
    public ResponseEntity<?> updateDiscountItem(Integer itemId, ItemUpdateDto itemUpdateDto){
        LocalDateTime lastUpdate = LocalDateTime.parse(itemUpdateDto.getLastUpdateAt(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Integer discount = itemUpdateDto.getDiscount();
        if(repository.updateDiscountItem(itemId,discount,lastUpdate)==1){
            return new ResponseEntity<>(Response.builder().message("SUCCESS").build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(Response.builder().message("ERROR"), HttpStatus.FOUND);
    }
    public ResponseEntity<?> updateNameItem(Integer itemId, ItemUpdateDto itemUpdateDto){
        LocalDateTime lastUpdate = LocalDateTime.parse(itemUpdateDto.getLastUpdateAt(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String name = itemUpdateDto.getName();
        if(repository.updateNameItem(itemId,name,lastUpdate)==1){
            return new ResponseEntity<>(Response.builder().message("SUCCESS").build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(Response.builder().message("ERROR"), HttpStatus.FOUND);
    }
    public ResponseEntity<?> updateDescriptionItem(Integer itemId,ItemUpdateDto itemUpdateDto){
        LocalDateTime lastUpdate = LocalDateTime.parse(itemUpdateDto.getLastUpdateAt(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String description = itemUpdateDto.getDescription();
        if(repository.updateDescriptionItem(itemId,description,lastUpdate)==1){
            return new ResponseEntity<>(Response.builder().message("SUCCESS").build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(Response.builder().message("ERROR"), HttpStatus.FOUND);
    }
    public ResponseEntity<ItemIdDto> getItemIdByName(String name){
        Integer itemId = repository.getIdByName(name);
        return new ResponseEntity<>(new ItemIdDto().builder().itemId(itemId).build(),HttpStatus.OK);
    }
}
