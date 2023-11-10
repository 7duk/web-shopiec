package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.comment.CommentDto;
import codes.rytis.logindemo.dto.replycomment.ReplyCommentDto;
import codes.rytis.logindemo.service.MessageService;
import codes.rytis.logindemo.service.ReplyCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replycomment")
public class ReplyCommentController {
    private final ReplyCommentService service;
    @PostMapping("/save")
    public ResponseEntity<?> saveReplyComment(@RequestBody ReplyCommentDto replyCommentDto){
        return service.saveReplyComment(replyCommentDto);
    }
    @PatchMapping("/check/{id}")
    public ResponseEntity<?>checkComment( @PathVariable("id") Integer repcmtId){
        return service.checkReplyComment(1,repcmtId);
    }
    @GetMapping("/checked/{cmID}")
    public List<ReplyCommentDto> getCommentChecked(@PathVariable("cmID") Integer cmID){
        return service.getReplyComment(1,cmID);
    }
    @GetMapping("/nocheck")
    public List<ReplyCommentDto> getCommentNoCheck(){
        return service.getNoCheckReplyComment(0);
    }
}
