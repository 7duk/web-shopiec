package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.deliverystatus.DeliveryStatusDto;
import codes.rytis.logindemo.dto.order.OrderDto;
import codes.rytis.logindemo.entity.DeliveryStatus;
import codes.rytis.logindemo.repository.DeliveryStatusRepository;
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
public class DeliveryStatusService {
    private final DeliveryStatusRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<DeliveryStatusDto> getDelivetyStausById(Integer DeStatusId){
        DeliveryStatus deliveryStatuses = repository.getDelivetyStausById(DeStatusId);
        if (deliveryStatuses != null) {
            DeliveryStatusDto deliveryStatusDto =  mapper.map(deliveryStatuses, DeliveryStatusDto.class);
            return new ResponseEntity<>(deliveryStatusDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

