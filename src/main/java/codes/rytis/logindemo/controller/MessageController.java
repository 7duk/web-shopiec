package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.message.MessageDto;
import codes.rytis.logindemo.service.MessageService;
import codes.rytis.logindemo.utils.DataTypeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private final MessageService service;
    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageDto message) {
        System.out.println("mess:" + message);
        try {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("message/messages-insert")
    public ResponseEntity<?> saveMessages(@RequestBody List<MessageDto> request){
        return service.saveMessages(request);
    }
    @GetMapping("/message/messages")
    public ResponseEntity<?> getMessagesFromChat(@RequestParam(name = "cId") String cId){
        return  service.getMessageFromChat(DataTypeUtils.ConvertStringToInt(cId));
    }
}

