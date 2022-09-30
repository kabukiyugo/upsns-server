package click.uploadSns.api.common.controllers.forms;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ImageForm {

  private int id;

  @NotNull
  List<String> imageFilePaths;

}
