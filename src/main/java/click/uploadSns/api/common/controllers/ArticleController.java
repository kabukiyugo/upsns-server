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

import click.uploadSns.api.common.controllers.forms.ArticleForm;
import click.uploadSns.api.common.controllers.forms.SearchForm;
import click.uploadSns.api.domain.exceptions.InvalidInputException;
import click.uploadSns.api.domain.models.Article;
import click.uploadSns.api.domain.models.Dtos.ArticleDto;
import click.uploadSns.api.domain.models.Dtos.DisplayDto;
import click.uploadSns.api.domain.services.ArticleService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

  @NonNull
  private final ArticleService _articleService;

  @GetMapping
  public List<ArticleDto> get() {
    return _articleService.findAll();
  }

  @GetMapping("/{id}")
  public ArticleDto get(@PathVariable("id") int id) {
    return _articleService.findById(id);
  }

  @GetMapping("/{id}/{userId}")
  public DisplayDto getDisplayArt(@PathVariable("id") int id, @PathVariable("userId") int userId) {
    return _articleService.findByTwoId(id, userId);
  }

  @GetMapping("/user/{userId}")
  public List<ArticleDto> getByUserId(@PathVariable("userId") int userId) {
    return _articleService.findByUserId(userId);
  }

  // @GetMapping("/search/{term}")
  // public List<ArticleDto> searchBySwitching(@PathVariable("term") String term,
  // @RequestParam(name = "SearchType", required = true) int type) {
  // if (type == 0) {
  // return _articleService.searchByTagName(term);
  // } else {
  // return _articleService.searchByTitle(term);
  // }
  // }

  @PostMapping("/search")
  public List<DisplayDto> searchBySwitching(@RequestBody @Validated SearchForm searchForm) {
    return _articleService.searchBySwitching(searchForm.getTerm(), searchForm.getType(), searchForm.getUserId());
  }

  @GetMapping("/timeline/{userId}")
  public List<DisplayDto> searchArtAndFav(@PathVariable("userId") int userId) {
    return _articleService.searchArtAndFav(userId);
  }

  @PostMapping
  public ArticleDto post(@RequestBody @Validated ArticleForm articleForm, BindingResult result)
      throws InvalidInputException {
    if (result.hasErrors()) {
      throw new InvalidInputException("登録に失敗しました。");
    }
    Article article = new Article(articleForm.getId(), articleForm.getTitle(), articleForm.getBody(),
        articleForm.getUserId(), articleForm.getImageIds(), articleForm.getTagIds());
    return _articleService.insert(article);
  }

  @PutMapping("/{id}")
  public ArticleDto put(@PathVariable("id") int id, @RequestBody @Validated ArticleForm articleForm,
      BindingResult result)
      throws InvalidInputException {
    if (result.hasErrors()) {
      throw new InvalidInputException("アップデートに失敗しました。");
    }
    Article article = new Article(id, articleForm.getTitle(), articleForm.getBody(),
        articleForm.getUserId(), articleForm.getImageIds(), articleForm.getTagIds());
    return _articleService.update(article);
  }

  @DeleteMapping("/{id}")
  public int delete(@PathVariable("id") int id) {
    return _articleService.delete(id);
  }
}
