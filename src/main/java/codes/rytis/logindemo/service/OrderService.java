package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.bill.BillDto;
import codes.rytis.logindemo.dto.order.OrderDto;
import codes.rytis.logindemo.dto.order.OrderSaveDto;
import codes.rytis.logindemo.dto.orderdeliverystatusdetail.OrderDeliveryStatusDetailDto;
import codes.rytis.logindemo.dto.orderdetail.OrderDetailDto;
import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.entity.Order;
import codes.rytis.logindemo.entity.OrderDetail;
import codes.rytis.logindemo.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<List<OrderDto>> getAllOrder() {
        List<Order> orders = repository.getAllOrder();
        if (orders != null) {
            List<OrderDto> orderDtos = orders.stream().map(o ->{
                OrderDto orderDto = mapper.map(o, OrderDto.class);
//                orderDto.setBill(o.getBill().get);
//                BillDto billDto = mapper.map(o.getBill(), BillDto.class);
//                billDto.setOrderId(o.getBill().getOrderId());
                return orderDto;
            }).toList();
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<OrderDto> getOrderById(Integer orderId){
        Order order = repository.getOrderById(orderId);
        if (order != null) {
            OrderDto orderDto = mapper.map(order, OrderDto.class);
            return new ResponseEntity<>(orderDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<OrderDto>> getOrderByCustomerId(Integer customerId){
        List<Order> orders = repository.getOrderByCustomerId(customerId);
        if (orders != null) {
            List<OrderDto> orderDtos = orders.stream().map(o ->{
                OrderDto orderDto = mapper.map(o, OrderDto.class);
                return orderDto;
            }).toList();
            return new ResponseEntity<>(orderDtos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> saveOrder(OrderSaveDto orderSaveDto) {
        Order order = mapper.map(orderSaveDto, Order.class);
        order.setPayMethodId(orderSaveDto.getPaymentMethodId());
        System.out.println(order.toString());
        try {
            repository.saveOrder(order);
            return new ResponseEntity<>(Response.builder().message("SUCCESS").build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Response.builder().message(e.getMessage()).build(), HttpStatus.FOUND);
        }

    }
}
