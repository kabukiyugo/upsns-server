package click.uploadSns.api.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import click.uploadSns.api.domain.models.Tag;
import click.uploadSns.api.domain.models.Dtos.TagDto;

@Mapper
public interface TagMapper {

  List<TagDto> findAll();

  Optional<TagDto> findById(int id);

  public void insert(Tag tag);

  public void insertTags(@Param("tags") List<Tag> tags);

  public void delete(int id);

}
