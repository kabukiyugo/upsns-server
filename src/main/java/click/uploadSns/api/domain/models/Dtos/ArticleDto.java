package click.uploadSns.api.domain.models.Dtos;

import java.util.List;

import lombok.Data;

@Data
public class ArticleDto {

    private int id;

    private String title;

    private String body;

    private UserDto user;

    private List<ImageDto> images;

    private List<TagDto> tags;

    private String insertTime;

    private String updateTime;

}
