package click.uploadSns.api.common.controllers.forms;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserForm {

    private int id;

    @NotNull
    private String name;

    @NotNull
    private String furigana;

    @NotNull
    private String mail;

    @NotNull
    private String telNo;

    @NotNull
    private String password;

    @NotNull
    private String role;

    private String iconImagePath;

    private String comment;

    private String cognitoId;

}
