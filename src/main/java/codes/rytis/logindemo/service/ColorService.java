package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.color.ColorDto;
import codes.rytis.logindemo.dto.color.ColorIdDto;
import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.entity.Color;
import codes.rytis.logindemo.repository.ColorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ColorService {
    private final ColorRepository repository;
    private final ModelMapper mapper;
    public ResponseEntity<?> saveColor(ColorDto colorDto){
        System.out.println(colorDto.toString());
        Color color = mapper.map(colorDto,Color.class);
        System.out.println(color.toString());
        if(repository.saveColor(color.getCode())==1){
            return new ResponseEntity<>(new Response().builder().message("SUCCCESS").build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    public ResponseEntity<?> getColorIdByCode(String code) {
        Integer colorId = repository.getIdByDescription(code);
        return new ResponseEntity<>(new ColorIdDto().builder().ColorId(colorId).build(),HttpStatus.OK);
    }
}
