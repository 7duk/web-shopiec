package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.service.BillService;
import codes.rytis.logindemo.service.DeliveryStatusService;
import codes.rytis.logindemo.utils.DataTypeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliverystatus")
@RequiredArgsConstructor
public class DeliveryStatusController {
    private final DeliveryStatusService service;

    @GetMapping("/status")
    public ResponseEntity<?> getDelivetyStausById(@RequestParam("delivery-status-id") String DeStatusId){
        return service.getDelivetyStausById(DataTypeUtils.ConvertStringToInt(DeStatusId));
    }

}
