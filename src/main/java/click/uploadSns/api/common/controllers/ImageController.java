package click.uploadSns.api.common.controllers;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import click.uploadSns.api.common.controllers.forms.ImageForm;
import click.uploadSns.api.domain.exceptions.InvalidInputException;
import click.uploadSns.api.domain.models.Dtos.ImageDto;
import click.uploadSns.api.domain.services.ImageService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin 
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

  @NonNull
  private final ImageService _imageService;

  @GetMapping
  public List<ImageDto> get() {
    return _imageService.findAll();
  }

  @GetMapping("/{id}")
  public ImageDto get(@PathVariable("id") int id) {
    return _imageService.findById(id);
  }

  @GetMapping("/latest")
  public ImageDto getTheLatest() {
    return _imageService.getTheLatest();
  }

  @PostMapping
  public List<Integer> post(@RequestBody @Validated ImageForm imageForm, BindingResult result)
      throws InvalidInputException {
    if (result.hasErrors()) {
      throw new InvalidInputException("登録に失敗しました。");
    }
    return _imageService.insert(imageForm.getImageFilePaths());
  }

  @DeleteMapping("/{id}")
  public int delete(@PathVariable("id") int id) {
    return _imageService.delete(id);
  }

  @DeleteMapping("/names")
  public List<String> deleteByIds(@RequestBody List<String> names) {
    return _imageService.deleteByNames(names);
  }

}
