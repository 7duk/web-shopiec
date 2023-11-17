package codes.rytis.logindemo.controller;


import codes.rytis.logindemo.dto.order.OrderSaveDto;
import codes.rytis.logindemo.service.OrderService;
import codes.rytis.logindemo.utils.DataTypeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService service;

    @GetMapping("/")
    public ResponseEntity<?> getAllOrder(){
        return service.getAllOrder();
    }

    @GetMapping("/order-detail")
    public ResponseEntity<?> getOrderById(@RequestParam("order-id") String OrderId){
        return service.getOrderById(DataTypeUtils.ConvertStringToInt(OrderId));
    }

    @GetMapping("/user-order")
    public ResponseEntity<?> getOrderByCustomerId(@RequestParam("customer-id") String CustomerId){
        return service.getOrderByCustomerId(DataTypeUtils.ConvertStringToInt(CustomerId));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveOrder(@RequestBody OrderSaveDto orderSaveDto){
        return service.saveOrder(orderSaveDto);
    }
}
