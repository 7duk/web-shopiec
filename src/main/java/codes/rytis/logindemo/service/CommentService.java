package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.comment.CommentDto;
import codes.rytis.logindemo.dto.item.ItemDto;
import codes.rytis.logindemo.dto.item.ItemUpdateDto;
import codes.rytis.logindemo.dto.participant.ParticipantDto;
import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.entity.Comment;
import codes.rytis.logindemo.repository.CommentRepository;
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
public class CommentService {
    private final CommentRepository repository;
    private final ModelMapper mapper;

    public ResponseEntity<?> saveComment(CommentDto commentDto) {
        System.out.println(commentDto.toString());
        Comment comment = mapper.map(commentDto, Comment.class);
        LocalDateTime time = LocalDateTime.parse(commentDto.getTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(time.toString());
        comment.builder().userId(commentDto.getUserId()).build();
        comment.setTime(time);
        System.out.println(comment.toString());
        return repository.saveComment(comment) == 1 ? new ResponseEntity<>(new Response("SUCCESS"), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.FOUND);
    }

    public ResponseEntity<?> checkComment(Integer isCheck, Integer cmId) {
        return repository.checkComment(isCheck, cmId) == 1 ? new ResponseEntity<>(new Response("SUCCESS"), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.FOUND);
    }

    public List<CommentDto> getComment(Integer isCheck, Integer itemId) {
        return repository.selectCMT(isCheck, itemId).stream().map(e -> {
            CommentDto commentDto = mapper.map(e, CommentDto.class);
            commentDto.setItemId(e.getItemId());
            commentDto.setParticipantDto(new ParticipantDto(e.getUser().getFirstName() + " " + e.getUser().getFirstName(), e.getUser().getImage()));
            commentDto.setItemUpdateDto(mapper.map(e.getItem(), ItemUpdateDto.class));
            return commentDto;
        }).toList();
    }

    public List<CommentDto> getCommentNoCheck(Integer isCheck) {
        return repository.selectCMTNoCheck(isCheck).stream().map(e -> {
            CommentDto commentDto = mapper.map(e, CommentDto.class);
            commentDto.setItemId(e.getItemId());
            commentDto.setParticipantDto(new ParticipantDto(e.getUser().getFirstName() + " " + e.getUser().getFirstName(), e.getUser().getImage()));
            commentDto.setItemUpdateDto(mapper.map(e.getItem(), ItemUpdateDto.class));
            return commentDto;
        }).toList();
    }
}
