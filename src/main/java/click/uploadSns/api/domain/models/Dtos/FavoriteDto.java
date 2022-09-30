package click.uploadSns.api.domain.models.Dtos;

import lombok.Data;

@Data
public class FavoriteDto {

    private int id;

    private UserDto pushUser;

    private ArticleDto article;

    private String insertTime;

    private String updateTime;

}
