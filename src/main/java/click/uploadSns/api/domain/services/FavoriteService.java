package click.uploadSns.api.domain.services;

import java.util.List;

import click.uploadSns.api.domain.models.Favorite;
import click.uploadSns.api.domain.models.Dtos.FavoriteDto;

public interface FavoriteService {

    List<FavoriteDto> findAll();

    FavoriteDto findById(int id);

    List<FavoriteDto> findByPushUserId(int userId);

    FavoriteDto findByIds(int articleId, int pushUserId);

    FavoriteDto insert(Favorite favorite);

    FavoriteDto update(Favorite favorite);

    int delete(int id);

}
