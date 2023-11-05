package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.itemgroup.ItemGroupDto;
import codes.rytis.logindemo.service.ItemGroupService;
import codes.rytis.logindemo.utils.DataTypeUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ig")
@RequiredArgsConstructor
public class IGroupController {
    private final ItemGroupService service;
    @PostMapping("/ig-insert")
    public ResponseEntity<?> saveIGroup(@RequestBody ItemGroupDto request){
        return service.saveIGroup(request);
    }
    @GetMapping("/all")
    public ResponseEntity<List<ItemGroupDto>> getItemGroups(){
        return service.getIGroupsIfNotDeleted(0);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> removeIgroup(@RequestParam(name = "igId") String igId){
        return service.removeIgById(DataTypeUtils.ConvertStringToInt(igId));
    }

}
