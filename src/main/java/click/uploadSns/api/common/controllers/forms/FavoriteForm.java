package click.uploadSns.api.common.controllers.forms;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class FavoriteForm {

    @NotNull
    private int id;

    @NotNull
    private int pushUserId;
  
    @NotNull
    private int articleId;
}
