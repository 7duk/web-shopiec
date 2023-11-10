package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.imageitem.ImageSaveDto;
import codes.rytis.logindemo.service.ImageItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imageitem")
@RequiredArgsConstructor
public class ImageItemController {
    private final ImageItemService service;
    @PostMapping("/save")
    public ResponseEntity<?> saveImageItems(@RequestBody List<ImageSaveDto> itemSaveDtos){
        return service.saveImageItems(itemSaveDtos);
    }
}
