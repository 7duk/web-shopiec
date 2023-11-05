package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.message.MessageDto;
import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.entity.Message;
import codes.rytis.logindemo.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper mapper;

    public ResponseEntity<?> saveMessages(List<MessageDto> messageDtos) {
        System.out.println(messageDtos.get(0));
        try {
            List<Message> messages = messageDtos.stream().map(e -> {
                Message mes = new Message().builder().time(LocalDateTime.parse(e.getTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).build();
                mapper.map(e, mes);
                return mes;
            }).toList();
            repository.saveAll(messages);
            return new ResponseEntity<>(new Response().builder().message("INSERT MESSAGES SUCCESS").build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
    }

    public ResponseEntity<?> getMessageFromChat(Integer cId) {
        List<Message> messages = repository.findAllByChatId(cId);
        List<MessageDto> messageDtos = messages.stream().map(e -> {
            MessageDto messageDto = new MessageDto().builder().chatId(e.getChatId()).senderId(e.getSenderId()).build();
            mapper.map(e, messageDto);
            return messageDto;
        }).toList();
        return new ResponseEntity<>(messageDtos, HttpStatus.OK);
    }
}
