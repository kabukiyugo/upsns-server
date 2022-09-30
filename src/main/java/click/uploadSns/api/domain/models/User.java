package click.uploadSns.api.domain.models;

// import java.util.List;

// import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

  // public User(String username, String password2, List<GrantedAuthority>
  // createAuthorityList) {
  // }

  private int id;

  private String name;

  private String furigana;

  private String mail;

  private String telNo;

  private String password;

  private String role;

  private String iconImagePath;

  private String comment;

  private String cognitoId;

}
