package click.uploadSns.api.common.controllers.forms;

import lombok.Data;

@Data
public class SearchForm {

  String term;

  int type;

  int userId;

}
