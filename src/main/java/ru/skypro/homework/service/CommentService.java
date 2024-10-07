package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import ru.skypro.homework.dto.CommentsDTO;
import ru.skypro.homework.dto.CreateOrUpdateCommentDTO;

public interface CommentService {
    CommentsDTO getCommentsForAd(Integer id, Authentication authentication);
    CreateOrUpdateCommentDTO getAddCommentToAd(Integer id, Authentication authentication);
    void getRemoveComment(Integer adId, Integer comId, Authentication authentication);
    CreateOrUpdateCommentDTO getUpdateComment(Integer adId, Integer comId, CreateOrUpdateCommentDTO commentsDTO, Authentication authentication);

}
