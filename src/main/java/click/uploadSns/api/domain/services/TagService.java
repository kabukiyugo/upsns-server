package click.uploadSns.api.domain.services;

import java.util.List;

import click.uploadSns.api.domain.models.Tag;
import click.uploadSns.api.domain.models.Dtos.TagDto;

public interface TagService {

    List<TagDto> findAll();

    TagDto findById(int id);

    TagDto insert(Tag tag);

    List<TagDto> insertTags(List<Tag> tags);

    int delete(int id);

}
