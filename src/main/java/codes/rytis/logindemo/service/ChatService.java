package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.ChatRequest;
import codes.rytis.logindemo.dto.MessageRequest;
import codes.rytis.logindemo.dto.Response;
import codes.rytis.logindemo.entity.Chat;
import codes.rytis.logindemo.entity.Message;
import codes.rytis.logindemo.entity.User;
import codes.rytis.logindemo.repository.ChatRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository repository;
    public Chat findChatByPARTICIPANT(ChatRequest request) {
        Optional<Chat> chat= repository.findChatByPARTICIPANT(request.getParticipant_1(), request.getParticipant_2());
        if(!chat.isEmpty()){
                return new Chat().builder().participantId1(chat.get().getParticipantId1())
                        .participantId2(chat.get().getParticipantId2())
                        .id(chat.get().getId())
                        .participaint2(new User(chat.get().getParticipaint2().getFirstName(),
                                chat.get().getParticipaint2().getLastName(),
                                chat.get().getParticipaint2().getGender(),
                                chat.get().getParticipaint2().getRoleId(),
                                chat.get().getParticipaint2().getImage()))
                        .messages(chat.get().getMessages().stream()
                                .map(t->{Message mes = new Message(t.getMessage(),
                                        t.getTime(),
                                        t.getSenderId(),
                                        t.getChatId());
                                    mes.setId(t.getId()); return mes;})
                                .toList()).build();
        }
        return null;
    }

    public List<Chat> findAll() {
        List<Chat> chats = repository.findAll();
        return chats.stream().map(e -> {
            return new Chat().builder().participantId1(e.getParticipantId1()).participantId2(e.getParticipantId2()).id(e.getId()).participaint2(new User(e.getParticipaint2().getFirstName(), e.getParticipaint2().getLastName(),e.getParticipaint2().getGender(),e.getParticipaint2().getRoleId(),e.getParticipaint2().getImage())).messages(e.getMessages().stream().map(t->{Message mes = new Message(t.getMessage(),t.getTime(),t.getSenderId(),t.getChatId()); mes.setId(t.getId()); return mes;}).toList()).build();
        }).toList();
    }

    @Transactional
    public int saveChat(ChatRequest request){
            return repository.saveChat(request.getParticipant_1(), request.getParticipant_2());
    }
}
