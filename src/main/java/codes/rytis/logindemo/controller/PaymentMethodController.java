package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.paymentmethod.PaymentMethodDto;
import codes.rytis.logindemo.service.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paymentmethod")
public class PaymentMethodController {
    private final PaymentMethodService service;
    @GetMapping("/all")
    public ResponseEntity<List<PaymentMethodDto>> getPaymentMethod() {
        return service.getPayMethodIfNotDeleted(0);
    }

    @GetMapping("/id")
    public ResponseEntity<List<PaymentMethodDto>> getPaymentMethodById() {
        return service.getPayMethodIfNotDeleted(0);
    }
}
