package click.uploadSns.api.domain.models.Dtos;

import lombok.Data;

@Data
public class SaveReplyDataDto {

    private int id;

    private String comment;

    private UserDto user;

    private int parentId;

    private String insertTime;

    private ArticleDto article;

}
