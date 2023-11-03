package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.ChatRequest;
import codes.rytis.logindemo.dto.Response;
import codes.rytis.logindemo.entity.Chat;
import codes.rytis.logindemo.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chatt")
public class ChatController {
    private final ChatService service;
    @PostMapping("/chat-insert")
    public ResponseEntity<?> saveChat(@RequestBody @Validated ChatRequest request){
        return new ResponseEntity<>(service.saveChat(request),HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Chat> chats = service.findAll();
        chats.stream().forEach(System.out::println);
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getChatById(@RequestParam String id){
        System.out.println(id);
        String[] ids = id.split(" ");
        ChatRequest request = new ChatRequest().builder().participant_1(Integer.parseInt(ids[0])).participant_2(Integer.parseInt(ids[1])).build();
        System.out.println(request.toString());
        Chat chat = service.findChatByPARTICIPANT(request);
        return new ResponseEntity<>(chat, HttpStatus.OK);
    }
}
