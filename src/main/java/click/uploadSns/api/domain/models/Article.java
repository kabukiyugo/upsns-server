package click.uploadSns.api.domain.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article {

  private int id;

  private String title;

  private String body;

  private int userId;

  private List<Integer> imageIds;

  private List<Integer> tagIds;

}
