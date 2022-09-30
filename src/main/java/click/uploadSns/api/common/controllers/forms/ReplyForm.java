package click.uploadSns.api.common.controllers.forms;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ReplyForm {

  private int id;

  @NotNull
  private String comment;

  @NotNull
  private int userId;

  private int parentId;

  @NotNull
  private int articleId;

}
