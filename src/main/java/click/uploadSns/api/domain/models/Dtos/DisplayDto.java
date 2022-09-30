package click.uploadSns.api.domain.models.Dtos;

import lombok.Data;

@Data
public class DisplayDto {

  ArticleDto article;

  Boolean isFavorite;

  int replyCount;

}