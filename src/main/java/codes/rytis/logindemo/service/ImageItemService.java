package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.imageitem.ImageSaveDto;
import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.repository.ImageItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ImageItemService{
    private final ImageItemRepository repository;
    public ResponseEntity<?> saveImageItems(List<ImageSaveDto> imageSaveDtos){
        repository.saveImages(imageSaveDtos);
        return  new ResponseEntity<>(new Response().builder().message("SUCCESS").build(), HttpStatus.OK);
    }
}

