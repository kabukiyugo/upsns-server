package click.uploadSns.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Favorite {

  private int id;

  private int pushUserId;

  private int articleId;

}
