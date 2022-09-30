package click.uploadSns.api.domain.services;

import java.util.List;

import click.uploadSns.api.domain.models.Dtos.ImageDto;

public interface ImageService {

    List<ImageDto> findAll();

    ImageDto findById(int id);

    ImageDto getTheLatest();

    ImageDto findByName(String name);

    List<Integer> insert(List<String> imageFilePaths);

    int delete(int id);

    List<String> deleteByNames(List<String> names);

}
