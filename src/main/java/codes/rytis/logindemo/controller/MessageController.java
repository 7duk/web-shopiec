package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.ChatRequest;
import codes.rytis.logindemo.dto.MessageRequest;
import codes.rytis.logindemo.dto.Response;
import codes.rytis.logindemo.service.ChatService;
import codes.rytis.logindemo.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private final MessageService service;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageRequest message) {
        System.out.println("mess:" + message);
        try {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("message/messages-insert")
    public ResponseEntity<?> saveMessages(@RequestBody List<MessageRequest> request){
        return service.saveMessages(request);
    }
}

