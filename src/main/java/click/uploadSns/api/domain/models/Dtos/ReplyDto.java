package click.uploadSns.api.domain.models.Dtos;

import java.util.List;

import lombok.Data;

@Data
public class ReplyDto {

    private int id;

    private String comment;

    private UserDto user;

    private List<ReplyDto> childrenReply;

    private String insertTime;

    private ArticleDto article;

}
