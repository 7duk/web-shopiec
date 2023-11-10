package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.color.ColorDto;
import codes.rytis.logindemo.dto.itemdetail.ItemDetailDto;
import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.entity.Color;
import codes.rytis.logindemo.entity.Item;
import codes.rytis.logindemo.entity.ItemDetail;
import codes.rytis.logindemo.repository.ItemDetailRepository;
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
public class ItemDetailService {
    private final ModelMapper mapper;
    private final ItemDetailRepository repository;

    public ResponseEntity<?> saveItemDetails(List<ItemDetailDto> itemDetailDtos) {
        List<ItemDetail> itemDetails = itemDetailDtos.stream().map(e -> {
            ItemDetail itemDetail = mapper.map(e, ItemDetail.class);
            System.out.println(itemDetail.toString());
            return itemDetail;
        }).toList();
        repository.saveItemDetails(itemDetails);
        return new ResponseEntity<>(new Response().builder().message("SUCCCESS").build(), HttpStatus.OK);

    }

}
