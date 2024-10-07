package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CommentsDTO;
import ru.skypro.homework.dto.CreateOrUpdateCommentDTO;
import ru.skypro.homework.service.CommentService;

@RestController
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("ads")
public class CommentController {

    private final CommentService commentService;

    @GetMapping(path = "/{id}/comments")
    public ResponseEntity<CommentsDTO> getCommentsForAd(@PathVariable Integer id, Authentication authentication) {
        CommentsDTO commentsDTO = commentService.getCommentsForAd(id, authentication);
        return ResponseEntity.ok(commentsDTO);
    }

    @PostMapping(path = "/{id}/comments")
    public ResponseEntity<CreateOrUpdateCommentDTO> getAddCommentToAd(@PathVariable Integer id, Authentication authentication) {
        CreateOrUpdateCommentDTO commentDTO = commentService.getAddCommentToAd(id, authentication);
        return ResponseEntity.ok(commentDTO);
    }

    @DeleteMapping(path = "/{adId}/comments/{commentId}")
    public ResponseEntity<?> getRemoveComment(@PathVariable Integer adId, @PathVariable Integer commentId, Authentication authentication) {
        commentService.getRemoveComment(adId, commentId, authentication);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping(path = "/{adId}/comments/{commentId}")
    public ResponseEntity<CreateOrUpdateCommentDTO> getUpdateComment(@PathVariable Integer adId, @PathVariable Integer commentId, CreateOrUpdateCommentDTO commentDTO, Authentication authentication) {
        CreateOrUpdateCommentDTO comment = commentService.getUpdateComment(adId, commentId, commentDTO, authentication);
        return ResponseEntity.ok(comment);
    }
}
