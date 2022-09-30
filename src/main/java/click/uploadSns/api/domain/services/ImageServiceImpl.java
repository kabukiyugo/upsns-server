package click.uploadSns.api.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import click.uploadSns.api.domain.models.Image;
import click.uploadSns.api.domain.models.Dtos.ImageDto;
import click.uploadSns.api.domain.repositories.ImageMapper;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

  private final ImageMapper _imageMapper;

  ImageServiceImpl(ImageMapper imageMapper) {
    this._imageMapper = imageMapper;
  }

  @Override
  public List<ImageDto> findAll() {
    return _imageMapper.findAll();
  }

  @Override
  public ImageDto findById(int id) {
    Optional<ImageDto> imgOpt = _imageMapper.findById(id);
    return imgOpt.get();
  }

  @Override
  public ImageDto insert(Image image) {
    _imageMapper.insert(image);
    return _imageMapper.findById(image.getId()).get();
  }

  @Override
  public ImageDto update(Image image) {
    _imageMapper.update(image);
    return _imageMapper.findById(image.getId()).get();
  }

  @Override
  public int delete(int id) {
    _imageMapper.delete(id);
    return id;
  }

}
