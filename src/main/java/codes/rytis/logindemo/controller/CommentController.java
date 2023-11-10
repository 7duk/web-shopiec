package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.comment.CommentDto;
import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.entity.Comment;
import codes.rytis.logindemo.service.CommentService;
import codes.rytis.logindemo.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService service;
    @PostMapping("/save")
    public ResponseEntity<?> saveComment(@RequestBody CommentDto commentDto){
        return service.saveComment(commentDto);
    }
    @PatchMapping("/check/{cmId}")
    public ResponseEntity<?>checkComment(@PathVariable("cmId") Integer cmId){
        return service.checkComment(1,cmId);
    }
    @GetMapping("/checked/{itemId}")
    public List<CommentDto> getCommentChecked(@PathVariable("itemId")  Integer itemId){
        return service.getComment(1,itemId);
    }
    @GetMapping("/nocheck")
    public List<CommentDto> getCommentNoCheck(){
        return service.getCommentNoCheck(0);
    }
}
