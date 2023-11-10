package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.color.ColorDto;
import codes.rytis.logindemo.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/color")
@RequiredArgsConstructor
public class ColorController {
    private final ColorService service;
    @PostMapping("/save")
    public ResponseEntity<?> saveColor(@RequestBody ColorDto dto){
        return service.saveColor(dto);
    }
    @GetMapping("/id")
    public ResponseEntity<?> getColorIdByCode(@RequestParam("code") String code){
        System.out.println("code:"+code);
        return service.getColorIdByCode(code);
    }
}
