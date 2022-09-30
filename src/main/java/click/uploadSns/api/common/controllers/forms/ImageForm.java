package click.uploadSns.api.common.controllers.forms;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ImageForm {

  @NotNull
  private int id;

  @NotNull
  private String imageFile;

  @NotNull
  private int articleId;

}
