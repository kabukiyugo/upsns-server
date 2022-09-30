package click.uploadSns.api.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import click.uploadSns.api.domain.models.Tag;
import click.uploadSns.api.domain.models.Dtos.TagDto;
import click.uploadSns.api.domain.repositories.TagMapper;

@Service
@Transactional
public class TagServiceImpl implements TagService {

  private final TagMapper _tagMapper;

  TagServiceImpl(TagMapper tagMapper) {
    this._tagMapper = tagMapper;
  }

  @Override
  public List<TagDto> findAll() {
    return _tagMapper.findAll();
  }

  @Override
  public TagDto findById(int id) {
    Optional<TagDto> tagOpt = _tagMapper.findById(id);
    return tagOpt.get();
  }

  @Override
  public TagDto insert(Tag tag) {
    _tagMapper.insert(tag);
    return _tagMapper.findById(tag.getId()).get();
  }

  @Override
  public List<TagDto> insertTags(List<Tag> tags) {
    _tagMapper.insertTags(tags);
    List<TagDto> resList = new ArrayList<>();
    for (Tag tag : tags) {
      _tagMapper.insert(tag);
      resList.add(_tagMapper.findById(tag.getId()).get());
    }
    return resList;
  }

  @Override
  public int delete(int id) {
    _tagMapper.delete(id);
    return id;
  }

}
