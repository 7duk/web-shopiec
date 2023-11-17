package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.imageitem.ImageItemDto;
import codes.rytis.logindemo.dto.item.ItemDto;
import codes.rytis.logindemo.dto.itemgroup.ItemGroupDto;
import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.entity.ItemGroup;
import codes.rytis.logindemo.repository.ItemGroupRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemGroupService {
    private final ItemGroupRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<?> saveIGroup(ItemGroupDto itemGroupDto){
        ItemGroup itemGroup = mapper.map(itemGroupDto, ItemGroup.class);
        itemGroup.setIsDelete(0);
        try {
            repository.save(itemGroup);
            return new ResponseEntity<>(Response.builder().message("INSERT ITEMGROUP SUCCESS").build(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(Response.builder().message(e.getMessage()).build(), HttpStatus.FOUND);
        }
    }
    public ResponseEntity<List<ItemGroupDto>> getIGroupsIfNotDeleted(Integer deleteValue){
        List<ItemGroup> igroups = repository.getItemGroupsByIsDelete(deleteValue);
        List<ItemGroupDto> igroupDtos = igroups.stream().map(e->{
            ItemGroupDto igDt0 = mapper.map(e, ItemGroupDto.class);
            List<ItemDto> itemDtos = e.getItems().stream().map(i->{
                ItemDto itemDto = mapper.map(i, ItemDto.class);
                List<ImageItemDto> imageIDtos = i.getImagesItem().stream().map(im->{
                    ImageItemDto imageIDto = mapper.map(im,ImageItemDto.class);
                    return imageIDto;
                }).toList();
//                itemDto.setImagesItem(imageIDtos);
                System.out.println(itemDto.toString());
                return itemDto;
            }).toList();
            igDt0.setItems(itemDtos);
            System.out.println(igDt0.toString());
            return igDt0;
        }).toList();
        return new ResponseEntity<>(igroupDtos,HttpStatus.OK);
    }
    public ResponseEntity<?> removeIgById(Integer igId){
        if(repository.removeIgById(igId)==1){
            return new ResponseEntity<>(new Response().builder().message("SUCCESS").build(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new Response().builder().message("ERROR").build(),HttpStatus.FOUND);
        }
    }
}
