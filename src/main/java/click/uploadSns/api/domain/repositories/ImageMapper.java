package click.uploadSns.api.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import click.uploadSns.api.domain.models.Image;
import click.uploadSns.api.domain.models.Dtos.ImageDto;

@Mapper
public interface ImageMapper {

  List<ImageDto> findAll();

  Optional<ImageDto> findById(int id);

  public void insert(Image image);

  public void update(Image image);

  public void delete(int id);

}
