package click.uploadSns.api.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import click.uploadSns.api.domain.models.Article;
import click.uploadSns.api.domain.models.Dtos.ArticleDto;
import click.uploadSns.api.domain.repositories.ArticleMapper;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

  private final ArticleMapper _articleMapper;

  ArticleServiceImpl(ArticleMapper articleMapper) {
    this._articleMapper = articleMapper;
  }

  @Override
  public List<ArticleDto> findAll() {
    return _articleMapper.findAll();
  }

  @Override
  public List<ArticleDto> getTheLatest() {
    return _articleMapper.getTheLatest();
  }

  @Override
  public ArticleDto findById(int id) {
    Optional<ArticleDto> artOpt = _articleMapper.findById(id);
    return artOpt.get();
  }

  @Override
  public List<ArticleDto> findByUserId(int userId) {
    return _articleMapper.findByUserId(userId);
  }

  @Override
  public List<ArticleDto> searchByTitle(String title) {
    return _articleMapper.searchByTitle(title);
  }

  @Override
  public List<ArticleDto> searchByTagName(String tagName) {
    return _articleMapper.searchByTagName(tagName);
  }

  @Override
  public ArticleDto insert(Article article) {
    _articleMapper.insert(article);
    if (article.getTagIds() != null) {
      for (int t : article.getTagIds()) {
        _articleMapper.addTag(article.getId(), t);
      }
    }
    return _articleMapper.findById(article.getId()).get();
  }

  @Override
  public ArticleDto update(Article article) {
    _articleMapper.update(article);
    _articleMapper.deleteTag(article.getId());
    if (article.getTagIds() != null) {
      for (int t : article.getTagIds()) {
        _articleMapper.addTag(article.getId(), t);
      }
    }
    return _articleMapper.findById(article.getId()).get();
  }

  @Override
  public int delete(int id) {
    _articleMapper.delete(id);
    return id;
  }

}
