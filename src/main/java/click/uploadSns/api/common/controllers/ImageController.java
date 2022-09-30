package click.uploadSns.api.common.controllers;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import click.uploadSns.api.common.controllers.forms.ImageForm;
import click.uploadSns.api.domain.exceptions.InvalidInputException;
import click.uploadSns.api.domain.models.Image;
import click.uploadSns.api.domain.models.Dtos.ImageDto;
import click.uploadSns.api.domain.services.ImageService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

  @PostMapping
  public ImageDto post(@RequestBody @Validated ImageForm imageForm, BindingResult result)
      throws InvalidInputException {
    if (result.hasErrors()) {
      throw new InvalidInputException("登録に失敗しました。");
    }
    Image image = new Image(imageForm.getId(), imageForm.getImageFile(), imageForm.getArticleId());
    return _imageService.insert(image);
  }

  @PutMapping("/{id}")
  public ImageDto put(@PathVariable("id") int id, @RequestBody @Validated ImageForm imageForm, BindingResult result)
      throws InvalidInputException {
    if (result.hasErrors()) {
      throw new InvalidInputException("アップデートに失敗しました。");
    }
    Image image = new Image(id, imageForm.getImageFile(), imageForm.getArticleId());
    return _imageService.update(image);
  }

  @DeleteMapping("/{id}")
  public int delete(@PathVariable("id") int id) {
    return _imageService.delete(id);
  }
}
