package click.uploadSns.api.domain.services;

import java.util.List;

import click.uploadSns.api.domain.models.Image;
import click.uploadSns.api.domain.models.Dtos.ImageDto;

public interface ImageService {

    List<ImageDto> findAll();

    ImageDto findById(int id);

    ImageDto insert(Image image);

    ImageDto update(Image image);

    int delete(int id);

}
