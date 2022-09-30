package click.uploadSns.api.common.controllers;

import java.util.List;

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

import click.uploadSns.api.common.controllers.forms.FavoriteForm;
import click.uploadSns.api.domain.exceptions.InvalidInputException;
import click.uploadSns.api.domain.models.Favorite;
import click.uploadSns.api.domain.models.Dtos.FavoriteDto;
import click.uploadSns.api.domain.services.FavoriteService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin 
@RequestMapping("/favorite")
@RequiredArgsConstructor
public class FavoriteController {

  @NonNull
  private final FavoriteService _favoriteService;

  @GetMapping
  public List<FavoriteDto> get() {
    return _favoriteService.findAll();
  }

  @GetMapping("/{id}")
  public FavoriteDto getOne(@PathVariable("id") int id) {
    return _favoriteService.findById(id);
  }

  @GetMapping("/pushArtcles/{userId}")
  public List<FavoriteDto> getByPushUser(@PathVariable("userId") int userId) {
    return _favoriteService.findByPushUserId(userId);
  }

  @GetMapping("/seachByIds/{articleId}/{pushUserId}")
  public FavoriteDto getByIds(@PathVariable("articleId") int articleId, @PathVariable("pushUserId") int pushUserId) {
    return _favoriteService.findByIds(articleId, pushUserId);
  }

  @PostMapping
  public FavoriteDto post(@RequestBody @Validated FavoriteForm favoriteForm, BindingResult result)
      throws InvalidInputException {
    if (result.hasErrors()) {
      throw new InvalidInputException("登録に失敗しました。");
    }
    Favorite favorite = new Favorite(favoriteForm.getId(), favoriteForm.getPushUserId(), favoriteForm.getArticleId());
    return _favoriteService.insert(favorite);
  }

  @PutMapping("/{id}")
  public FavoriteDto put(@PathVariable("id") int id, @RequestBody @Validated FavoriteForm favoriteForm,
      BindingResult result)
      throws InvalidInputException {
    if (result.hasErrors()) {
      throw new InvalidInputException("アップデートに失敗しました。");
    }
    Favorite favorite = new Favorite(id, favoriteForm.getPushUserId(), favoriteForm.getArticleId());
    return _favoriteService.update(favorite);
  }

  @DeleteMapping("/{id}")
  public int delete(@PathVariable("id") int id) {
    return _favoriteService.delete(id);
  }
}
