package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.dto.chat.ChatDto;
import codes.rytis.logindemo.dto.message.MessageDto;
import codes.rytis.logindemo.dto.participant.ParticipantDto;
import codes.rytis.logindemo.entity.Chat;
import codes.rytis.logindemo.entity.Message;
import codes.rytis.logindemo.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository repository;
    private final ModelMapper mapper;

    public Integer findChatByPARTICIPANT(ChatDto request){
        try{
            Integer chat = repository.findChatIdByParticipaint(request.getParticipantId1(), request.getParticipantId2());
            return chat;
        }
        catch (Exception e){
            return  null;
        }
    }
    public List<ChatDto> findAll() {
        List<Chat> chats = repository.findAll();
        return chats.stream().map(e -> {
            System.out.println("1");
            ChatDto chatDto = mapper.map(e, ChatDto.class);
            System.out.println("2");
            Message message = e.getMessages().size() > 0 ? e.getMessages().get(e.getMessages().size() - 1) : null;
            System.out.println("3");
            ParticipantDto participantDto = new ParticipantDto().builder()
                    .name(e.getParticipaint2().getFirstName() + " " + e.getParticipaint2().getLastName())
                    .image(e.getParticipaint2().getImage()).build();
            MessageDto messageDto = message == null ? null : new MessageDto().builder()
                    .id(message.getId())
                    .message(message.getMessage())
                    .time(message.getTime().toString())
                    .chatId(message.getChatId())
                    .senderId(message.getSenderId()).build();
            System.out.println("4");
            chatDto.setMessages(messageDto);
            chatDto.setParticipant(participantDto);
            System.out.println("5");
            return chatDto;
        }).toList();
    }
    @Transactional
    public ResponseEntity<?> saveChat(ChatDto request) {
        Integer value = repository.saveChat(request.getParticipantId1(), request.getParticipantId2());
        if(value ==1){
            return new ResponseEntity<>(new Response().builder().message("INSERT CHAT SUCCESS").build(), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.FOUND);
    }
}
