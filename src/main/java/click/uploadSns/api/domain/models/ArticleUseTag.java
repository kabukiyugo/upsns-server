package click.uploadSns.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleUseTag {

    private int articleId;

    private int tagId;

}
