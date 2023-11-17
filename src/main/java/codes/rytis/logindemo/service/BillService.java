package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.bill.BillDto;
import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.entity.Bill;
import codes.rytis.logindemo.entity.Order;
import codes.rytis.logindemo.repository.BillRepository;
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
public class BillService {
    private final BillRepository repository;
    private final ModelMapper mapper;
    public ResponseEntity<?> saveBill(BillDto billDto) {
        Bill bill = mapper.map(billDto, Bill.class);
        bill.setOrderId(billDto.getOrderId());
        System.out.println(bill.toString());
        try {
            repository.saveBill(bill);
            return new ResponseEntity<>(Response.builder().message("SUCCESS").build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Response.builder().message(e.getMessage()).build(), HttpStatus.FOUND);
        }

    }
    public ResponseEntity<List<BillDto>> getAllBill(){
        List<Bill> bills = repository.getAllBill();
        List<BillDto> billDtos = bills.stream().map(b ->{
            BillDto billDto = mapper.map(b, BillDto.class);
            billDto.setOrderId(b.getOrderId());
            System.out.println(billDto.toString());
            return billDto;
        }).toList();
        return new ResponseEntity<>(billDtos, HttpStatus.OK);
    }
}
