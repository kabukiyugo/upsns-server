package click.uploadSns.api.domain.models.Dtos;

import lombok.Data;

@Data
public class UserDto {

    private int id;

    private String name;

    private String furigana;

    private String mail;

    private String telNo;

    private String password;

    private String role;

    private String insertTime;

    private String updateTime;

    private String iconImagePath;

    private String comment;

    private String cognitoId;

}
