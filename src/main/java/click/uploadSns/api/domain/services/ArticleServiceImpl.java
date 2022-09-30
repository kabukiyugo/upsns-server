package click.uploadSns.api.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import click.uploadSns.api.domain.models.Article;
import click.uploadSns.api.domain.models.Dtos.ArticleDto;
import click.uploadSns.api.domain.models.Dtos.DisplayDto;
import click.uploadSns.api.domain.models.Dtos.FavoriteDto;
import click.uploadSns.api.domain.repositories.ArticleMapper;
import click.uploadSns.api.domain.repositories.FavoriteMapper;
import click.uploadSns.api.domain.repositories.ReplyMapper;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

  private final ArticleMapper _articleMapper;

  private final FavoriteMapper _favoriteMapper;

  private final ReplyMapper _replyMapper;

  ArticleServiceImpl(ArticleMapper articleMapper, FavoriteMapper favoriteMapper, ReplyMapper replyMapper) {
    this._articleMapper = articleMapper;
    this._favoriteMapper = favoriteMapper;
    this._replyMapper = replyMapper;
  }

  @Override
  public List<ArticleDto> findAll() {
    return _articleMapper.findAll();
  }

  @Override
  public List<DisplayDto> searchArtAndFav(int userId) {
    List<ArticleDto> articleList = _articleMapper.getTheLatest();
    List<FavoriteDto> favoriteList = _favoriteMapper.findByPushUserId(userId);
    List<DisplayDto> displayList = new ArrayList<>();
    for (ArticleDto art : articleList) {
      DisplayDto DisplayDto = new DisplayDto();
      DisplayDto.setArticle(art);
      DisplayDto.setIsFavorite(false);
      for (FavoriteDto fav : favoriteList) {
        if (art.getId() == fav.getArticle().getId()) {
          DisplayDto.setIsFavorite(true);
          break;
        }
      }
      DisplayDto.setReplyCount(_replyMapper.findByArticleId(art.getId()).size());
      displayList.add(DisplayDto);
    }
    return displayList;
  }

  @Override
  public ArticleDto findById(int id) {
    Optional<ArticleDto> artOpt = _articleMapper.findById(id);
    return artOpt.get();
  }

  @Override
  public DisplayDto findByTwoId(int id, int userId) {
    Optional<ArticleDto> artOpt = _articleMapper.findById(id);
    Optional<FavoriteDto> favOpt = _favoriteMapper.findByIds(id, userId);
    DisplayDto displayDto = new DisplayDto();
    displayDto.setArticle(artOpt.get());
    displayDto.setIsFavorite(false);
    favOpt.ifPresent(x -> {
      displayDto.setIsFavorite(true);
    });
    displayDto.setReplyCount(_replyMapper.findByArticleId(id).size());
    return displayDto;
  }

  @Override
  public List<ArticleDto> findByUserId(int userId) {
    return _articleMapper.findByUserId(userId);
  }

  @Override
  public List<DisplayDto> searchBySwitching(String term, int type, int userId) {
    List<DisplayDto> displayList = new ArrayList<>();
    List<ArticleDto> searchList = new ArrayList<>();
    if (type == 0) {
      searchList = _articleMapper.searchByTagName(term);
    } else {
      searchList = _articleMapper.searchByTitle(term);
    }
    searchList.forEach(article -> {
      DisplayDto displayDto = new DisplayDto();
      displayDto.setArticle(article);
      var res = _favoriteMapper.findByIds(article.getId(), userId);
      displayDto.setIsFavorite(res.isPresent());
      displayList.add(displayDto);
    });
    return displayList;
  }

  // @Override
  // public List<ArticleDto> searchByTitle(String title) {
  // return _articleMapper.searchByTitle(title);
  // }

  // @Override
  // public List<ArticleDto> searchByTagName(String tagName) {
  // return _articleMapper.searchByTagName(tagName);
  // }

  @Override
  public ArticleDto insert(Article article) {
    _articleMapper.insert(article);
    if (article.getImageIds() != null) {
      for (int i : article.getImageIds()) {
        _articleMapper.addImage(article.getId(), i);
      }
    }
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
    _articleMapper.deleteImage(article.getId());
    _articleMapper.deleteTag(article.getId());
    if (article.getImageIds() != null) {
      for (int i : article.getImageIds()) {
        _articleMapper.addImage(article.getId(), i);
      }
    }
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
