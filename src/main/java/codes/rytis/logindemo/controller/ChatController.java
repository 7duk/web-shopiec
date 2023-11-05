package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.chat.ChatDto;
import codes.rytis.logindemo.dto.chat.ChatIdDto;
import codes.rytis.logindemo.service.ChatService;
import codes.rytis.logindemo.utils.DataTypeUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chatt")
public class ChatController {
    private final ChatService service;
    @PostMapping("/chat-insert")
    public ResponseEntity<?> saveChat(@RequestBody @Validated ChatDto request){
        return service.saveChat(request);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<ChatDto> chats = service.findAll();
        chats.stream().forEach(System.out::println);
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }
    @GetMapping("/get-cid")
    public ResponseEntity<?> getChatById(@RequestParam String id) {
        System.out.println(id);
        String[] ids = id.split(" ");
        ChatDto request = new ChatDto().builder().participantId1(DataTypeUtils.ConvertStringToInt(ids[0])).participantId2(DataTypeUtils.ConvertStringToInt(ids[1])).build();
        System.out.println(request.toString());
        Integer chatId = service.findChatByPARTICIPANT(request);
        return new ResponseEntity<>(new ChatIdDto().builder().idChat(chatId).build(), HttpStatus.OK);
    }
}
