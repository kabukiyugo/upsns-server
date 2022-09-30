package click.uploadSns.api.domain.services;

import java.util.List;

import click.uploadSns.api.domain.models.Article;
import click.uploadSns.api.domain.models.Dtos.ArticleDto;

public interface ArticleService {

  List<ArticleDto> findAll();

  List<ArticleDto> getTheLatest();

  ArticleDto findById(int id);

  List<ArticleDto> findByUserId(int userId);

  List<ArticleDto> searchByTitle(String title);

  List<ArticleDto> searchByTagName(String tagName);

  ArticleDto insert(Article article);

  ArticleDto update(Article article);

  int delete(int id);

}
