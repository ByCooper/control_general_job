package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import ru.skypro.homework.dto.CreateOrUpdateCommentDTO;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.model.User;

@Mapper
public interface CommentsMapper {

    @Mappings({
            @Mapping(target = "author",source = "id", qualifiedByName = "UserToComment"),
            @Mapping(target = "pk", source = "id", qualifiedByName = "AdToComment")
    })
    Comment commentToCreateCommentDTO(CreateOrUpdateCommentDTO commentDTO);

    @Mappings({
            @Mapping(target = "author",source = "id", qualifiedByName = "UserToComment"),
            @Mapping(target = "pk", source = "id", qualifiedByName = "AdToComment")
    })
    Comment commentToUpdateCommentDTO(CreateOrUpdateCommentDTO commentDTO);


    @Named("UserToComment")
    default Long UserToComment(User user) {
        return user.getId();
    }

    @Named("AdToComment")
    default Long AdToComment(Ad ad) {
        return ad.getId();
    }
}
