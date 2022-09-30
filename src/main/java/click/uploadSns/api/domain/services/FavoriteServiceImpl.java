package click.uploadSns.api.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import click.uploadSns.api.domain.models.Favorite;
import click.uploadSns.api.domain.models.Dtos.FavoriteDto;
import click.uploadSns.api.domain.repositories.FavoriteMapper;

@Service
@Transactional
public class FavoriteServiceImpl implements FavoriteService {

  private final FavoriteMapper _favoriteMapper;

  FavoriteServiceImpl(FavoriteMapper favoriteMapper) {
    this._favoriteMapper = favoriteMapper;
  }

  @Override
  public List<FavoriteDto> findAll() {
    return _favoriteMapper.findAll();
  }

  @Override
  public FavoriteDto findById(int id) {
    Optional<FavoriteDto> favOpt = _favoriteMapper.findById(id);
    return favOpt.get();
  }

  @Override
  public List<FavoriteDto> findByPushUserId(int userId) {
    return _favoriteMapper.findByPushUserId(userId);
  }

  @Override
  public FavoriteDto findByIds(int articleId, int pushUserId) {
    Optional<FavoriteDto> favOpt = _favoriteMapper.findByIds(articleId, pushUserId);
    return favOpt.get();
  }

  @Override
  public FavoriteDto insert(Favorite favorite) {
    _favoriteMapper.insert(favorite);
    return _favoriteMapper.findById(favorite.getId()).get();
  }

  @Override
  public FavoriteDto update(Favorite favorite) {
    _favoriteMapper.update(favorite);
    return _favoriteMapper.findById(favorite.getId()).get();
  }

  @Override
  public int delete(int id) {
    _favoriteMapper.delete(id);
    return id;
  }

}
