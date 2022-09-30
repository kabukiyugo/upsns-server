package click.uploadSns.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reply {

    private int id;

    private String comment;

    private int userId;

    private int parentId;

    private int articleId;

}
