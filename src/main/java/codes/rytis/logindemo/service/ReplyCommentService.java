package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.comment.CommentDto;
import codes.rytis.logindemo.dto.replycomment.ReplyCommentDto;
import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.entity.Comment;
import codes.rytis.logindemo.entity.ReplyComment;
import codes.rytis.logindemo.repository.ReplyCommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyCommentService {
    private final ReplyCommentRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<?> saveReplyComment(ReplyCommentDto replyCommentDto) {
        System.out.println(replyCommentDto.toString());
        ReplyComment replyComment = mapper.map(replyCommentDto, ReplyComment.class);
        LocalDateTime time = LocalDateTime.parse(replyCommentDto.getTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        replyComment.setTime(time);
        System.out.println(replyComment.toString());
        replyComment.builder().time(LocalDateTime.parse(replyCommentDto.getTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).build();
        return repository.saveComment(replyComment) == 1 ? new ResponseEntity<>(new Response("SUCCESS"), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.FOUND);
    }

    public ResponseEntity<?> checkReplyComment(Integer isCheck, Integer repcmtId) {
        return repository.checkReplyComment(repcmtId, isCheck) == 1 ? new ResponseEntity<>(new Response("SUCCESS"), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.FOUND);
    }

    public List<ReplyCommentDto> getReplyComment(Integer isCheck, Integer cmtId) {
        return repository.selectReplyCMT(cmtId, isCheck).stream().map(e -> {
            ReplyCommentDto replyCommentDto= mapper.map(e, ReplyCommentDto.class);
            replyCommentDto.setUserId(e.getUserId());
            replyCommentDto.setCommentId(e.getCommentId());
            return replyCommentDto;
        }).toList();
    }

    public List<ReplyCommentDto> getNoCheckReplyComment(Integer isCheck) {
        return repository.selectNoCheckReplyCMT(isCheck)
                .stream()
                .map(e -> {
                    ReplyCommentDto replyCommentDto= mapper.map(e, ReplyCommentDto.class);
                    replyCommentDto.setUserId(e.getUserId());
                    replyCommentDto.setCommentId(e.getCommentId());
                    return replyCommentDto;
                }).toList();
    }

}
