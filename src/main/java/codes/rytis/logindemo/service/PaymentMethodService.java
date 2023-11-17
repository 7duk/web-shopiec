package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.paymentmethod.PaymentMethodDto;
import codes.rytis.logindemo.entity.PaymentMethod;
import codes.rytis.logindemo.repository.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentMethodService {
    private final PaymentMethodRepository repository;
    private final ModelMapper mapper;
    public ResponseEntity<List<PaymentMethodDto>> getPayMethodIfNotDeleted(Integer deleteValue) {
        List<PaymentMethod> paymentMethods = repository.getPaymentMethodsByIsDelete(deleteValue);
        List<PaymentMethodDto> paymentMethodDtos = paymentMethods.stream()
                .map(paymentMethod -> mapper.map(paymentMethod, PaymentMethodDto.class)).toList();
        return new ResponseEntity<>(paymentMethodDtos, HttpStatus.OK);
    }
}
