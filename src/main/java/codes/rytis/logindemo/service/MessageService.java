package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.MessageRequest;
import codes.rytis.logindemo.dto.Response;
import codes.rytis.logindemo.entity.Message;
import codes.rytis.logindemo.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository repository;

    public ResponseEntity<?> saveMessages(List<MessageRequest> messageRequests) {
        System.out.println(messageRequests.get(0));
        List<Message> messages = messageRequests.stream().map(e -> {
            Message mes = new Message(e.getMessage(), LocalDateTime.parse(e.getTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), e.getSenderId(), e.getChatId());
            System.out.println(mes.toString());
            return mes;
        }).toList();
        try {
            repository.saveAll(messages);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }


    }
}
