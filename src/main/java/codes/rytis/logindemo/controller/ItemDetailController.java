package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.itemdetail.ItemDetailDto;
import codes.rytis.logindemo.dto.itemgroup.ItemGroupDto;
import codes.rytis.logindemo.service.ItemDetailService;
import codes.rytis.logindemo.service.ItemGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itemdetail")
@RequiredArgsConstructor
public class ItemDetailController {
    private final ItemDetailService service;
    @PostMapping("/save")
    public ResponseEntity<?> saveIGroup(@RequestBody List<ItemDetailDto> itemDetailDtos){
        return service.saveItemDetails(itemDetailDtos);
    }
}
