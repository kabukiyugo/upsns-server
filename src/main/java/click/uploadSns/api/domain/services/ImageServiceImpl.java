package click.uploadSns.api.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
  public ImageDto getTheLatest() {
    Optional<ImageDto> imgOpt = _imageMapper.getTheLatest();
    return imgOpt.get();
  }

  @Override
  public ImageDto findByName(String name) {
    Optional<ImageDto> imgOpt = _imageMapper.findByName(name);
    return imgOpt.get();
  }

  @Override
  public List<Integer> insert(List<String> imageFilePaths) {
    var images = imageFilePaths.stream().map(path -> {
      var img = new Image();
      img.setImageFilePath(path);
      return img;
    }).collect(Collectors.toList());
    _imageMapper.insert(images);
    List<Integer> ids = images.stream().map(image -> {
      return image.getId();
    }).collect(Collectors.toList());
    return ids;
  }

  @Override
  public int delete(int id) {
    _imageMapper.delete(id);
    return id;
  }

  @Override
  public List<String> deleteByNames(List<String> names) {
    _imageMapper.deleteByNames(names);
    return names;
  }

}
