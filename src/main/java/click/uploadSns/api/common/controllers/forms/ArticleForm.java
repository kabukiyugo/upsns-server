package click.uploadSns.api.common.controllers.forms;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ArticleForm {

  private int id;

  @NotNull
  private String title;

  @NotNull
  private String body;

  @NotNull
  private int userId;

  private List<Integer> imageIds;

  private List<Integer> tagIds;

}
