package click.uploadSns.api.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import click.uploadSns.api.domain.models.Favorite;
import click.uploadSns.api.domain.models.Dtos.FavoriteDto;

@Mapper
public interface FavoriteMapper {

  List<FavoriteDto> findAll();

  Optional<FavoriteDto> findById(int id);

  List<FavoriteDto> findByPushUserId(int userId);

  public void insert(Favorite favorite);

  public void update(Favorite favorite);

  public void delete(int id);

}
