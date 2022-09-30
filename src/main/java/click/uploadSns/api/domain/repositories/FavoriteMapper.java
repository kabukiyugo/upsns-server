package click.uploadSns.api.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import click.uploadSns.api.domain.models.Favorite;
import click.uploadSns.api.domain.models.Dtos.FavoriteDto;

@Mapper
public interface FavoriteMapper {

  List<FavoriteDto> findAll();

  Optional<FavoriteDto> findById(int id);

  List<FavoriteDto> findByPushUserId(int userId);

  Optional<FavoriteDto> findByIds(@Param("articleId") int articleId, @Param("pushUserId") int pushUserId);

  public void insert(Favorite favorite);

  public void update(Favorite favorite);

  public void delete(int id);

}
