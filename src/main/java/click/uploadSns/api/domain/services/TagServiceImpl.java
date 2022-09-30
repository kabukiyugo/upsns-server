package click.uploadSns.api.domain.services;

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
  public TagDto update(Tag tag) {
    _tagMapper.update(tag);
    return _tagMapper.findById(tag.getId()).get();
  }

  @Override
  public int delete(int id) {
    _tagMapper.delete(id);
    return id;
  }

}
