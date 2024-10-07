package ru.skypro.homework.dto;

import lombok.Data;
import ru.skypro.homework.model.Comment;

import java.util.List;

@Data
public class CommentsDTO {
    private int count;
    private List<Comment> results;
}
