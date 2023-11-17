package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.bill.BillDto;
import codes.rytis.logindemo.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bill")
@RequiredArgsConstructor
public class BillController {
    private final BillService service;

    @PostMapping("/save")
    public ResponseEntity<?> saveBill(@RequestBody BillDto billDto) {
        return service.saveBill(billDto);
    }
    @GetMapping("/bills")
    public ResponseEntity<?> getAllBill(){
        return service.getAllBill();
    }
}
