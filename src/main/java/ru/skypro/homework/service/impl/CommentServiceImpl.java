package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentsDTO;
import ru.skypro.homework.dto.CreateOrUpdateCommentDTO;
import ru.skypro.homework.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public CommentsDTO getCommentsForAd(Integer id, Authentication authentication) {
        return null;
    }

    @Override
    public CreateOrUpdateCommentDTO getAddCommentToAd(Integer id, Authentication authentication) {
        return null;
    }

    @Override
    public void getRemoveComment(Integer adId, Integer comId, Authentication authentication) {

    }

    @Override
    public CreateOrUpdateCommentDTO getUpdateComment(Integer adId, Integer comId, CreateOrUpdateCommentDTO commentsDTO, Authentication authentication) {
        return null;
    }
}
