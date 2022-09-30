package click.uploadSns.api.domain.services;

import java.util.List;

import click.uploadSns.api.domain.models.Article;
import click.uploadSns.api.domain.models.Dtos.ArticleDto;
import click.uploadSns.api.domain.models.Dtos.DisplayDto;

public interface ArticleService {

  List<ArticleDto> findAll();

  List<DisplayDto> searchArtAndFav(int userId);

  ArticleDto findById(int id);

  DisplayDto findByTwoId(int id, int userId);

  List<ArticleDto> findByUserId(int userId);

  List<DisplayDto> searchBySwitching(String term, int type, int userId);

  // List<ArticleDto> searchByTitle(String title);

  // List<ArticleDto> searchByTagName(String tagName);

  ArticleDto insert(Article article);

  ArticleDto update(Article article);

  int delete(int id);

}
