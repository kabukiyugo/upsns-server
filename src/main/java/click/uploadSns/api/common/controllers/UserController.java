package click.uploadSns.api.common.controllers;

import java.util.List;

// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import click.uploadSns.api.common.controllers.forms.UserForm;
import click.uploadSns.api.domain.exceptions.InvalidInputException;
import click.uploadSns.api.domain.models.User;
import click.uploadSns.api.domain.models.Dtos.UserDto;
import click.uploadSns.api.domain.services.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin 
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  @NonNull
  private final UserService _userService;

  @GetMapping
  public List<UserDto> get() {
    return _userService.findAll();
  }

  @GetMapping("/{id}")
  public UserDto get(@PathVariable("id") int id) {
    return _userService.findById(id);
  }

  @GetMapping("/cognitoId/{cognitoId}")
  public UserDto getByCognitoId(@PathVariable("cognitoId") String cognitoId) {
    return _userService.findByCognitoId(cognitoId);
  }

  // @GetMapping("/{name}") // postmanで検証中だけどやり方わからん
  // public UserDto get(@PathVariable("name") String username) {
  // return _userService.findByUserName(username);
  // }

  @PostMapping
  public UserDto post(@RequestBody @Validated UserForm userForm, BindingResult result)
      throws InvalidInputException {
    if (result.hasErrors()) {
      throw new InvalidInputException("登録に失敗しました。");
    }
    User user = new User(userForm.getId(), userForm.getName(),
        userForm.getFurigana(),
        userForm.getMail(), userForm.getTelNo(), userForm.getPassword(),
        userForm.getRole(),
        userForm.getIconImagePath(), userForm.getComment(), userForm.getCognitoId());
    // ここにエンコードの記述してハッシュ化？vueとcognitoだからいらない、パスワードもいらない
    return _userService.insert(user);
  }

  @PutMapping("/{id}")
  public UserDto put(@PathVariable("id") int id, @RequestBody @Validated UserForm userForm, BindingResult result)
      throws InvalidInputException {
    if (result.hasErrors()) {
      throw new InvalidInputException("アップデートに失敗しました。");
    }
    User user = new User(id, userForm.getName(), userForm.getFurigana(),
        userForm.getMail(), userForm.getTelNo(), userForm.getPassword(),
        userForm.getRole(),
        userForm.getIconImagePath(), userForm.getComment(), userForm.getCognitoId());

    return _userService.update(user);
  }

  @DeleteMapping("/{id}")
  public int delete(@PathVariable("id") int id) {
    return _userService.delete(id);
  }

  // @NonNull
  // private final PasswordEncoder _encoder;
  // // 丸ごとイランて言われた

}
