package click.uploadSns.api.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import click.uploadSns.api.domain.models.Image;
import click.uploadSns.api.domain.models.Dtos.ImageDto;

@Mapper
public interface ImageMapper {

  List<ImageDto> findAll();

  Optional<ImageDto> findById(int id);

  Optional<ImageDto> getTheLatest();

  Optional<ImageDto> findByName(@Param("name") String name);

  public void insert(@Param("imageFilePaths") List<Image> imageFilePaths);

  public void delete(int id);

  public void deleteByNames(@Param("names") List<String> names);

}
