package click.uploadSns.api.common.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import click.uploadSns.api.common.controllers.forms.TagForm;
import click.uploadSns.api.domain.exceptions.InvalidInputException;
import click.uploadSns.api.domain.models.Tag;
import click.uploadSns.api.domain.models.Dtos.TagDto;
import click.uploadSns.api.domain.services.TagService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

  @NonNull
  private final TagService _tagService;

  @GetMapping
  public List<TagDto> get() {
    return _tagService.findAll();
  }

  @GetMapping("/{id}")
  public TagDto get(@PathVariable("id") int id) {
    return _tagService.findById(id);
  }

  @PostMapping
  public TagDto post(@RequestBody @Validated TagForm tagForm, BindingResult result)
      throws InvalidInputException {
    if (result.hasErrors()) {
      throw new InvalidInputException("登録に失敗しました。");
    }
    Tag tag = new Tag(tagForm.getId(), tagForm.getName());
    return _tagService.insert(tag);
  }

  @PostMapping("/all")
  public List<TagDto> postTags(@RequestBody List<TagForm> tagForms)
      throws InvalidInputException {
    List<Tag> tags = tagForms.stream().map(tagForm -> new Tag(tagForm.getId(), tagForm.getName()))
        .collect(Collectors.toList());
    return _tagService.insertTags(tags);
  }

  @DeleteMapping("/{id}")
  public int delete(@PathVariable("id") int id) {
    return _tagService.delete(id);
  }
}