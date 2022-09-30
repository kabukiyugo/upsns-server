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

import click.uploadSns.api.common.controllers.forms.ReplyForm;
import click.uploadSns.api.domain.exceptions.InvalidInputException;
import click.uploadSns.api.domain.models.Reply;
import click.uploadSns.api.domain.models.Dtos.ReplyDto;
import click.uploadSns.api.domain.services.ReplyService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

  @NonNull
  private final ReplyService _replyService;

  @GetMapping
  public List<ReplyDto> get() {
    return _replyService.findAll();
  }

  @GetMapping("/{id}")
  public ReplyDto get(@PathVariable("id") int id) {
    return _replyService.findById(id);
  }

  @GetMapping("/search/{articleId}")
  public List<ReplyDto> getArticle(@PathVariable("articleId") int articleId) {
    return _replyService.findByArticleId(articleId);
  }

  @GetMapping("/notification/{userId}")
  public List<ReplyDto> notification(@PathVariable("userId") int userId) {
    return _replyService.findNotification(userId);
  }

  @PostMapping
  public ReplyDto post(@RequestBody @Validated ReplyForm replyForm, BindingResult result)
      throws InvalidInputException {
    if (result.hasErrors()) {
      throw new InvalidInputException("登録に失敗しました。");
    }
    Reply reply = new Reply(replyForm.getId(), replyForm.getComment(), replyForm.getUserId(),
        replyForm.getParentId(), replyForm.getArticleId());
    return _replyService.insert(reply);
  }

  @DeleteMapping("/{id}")
  public int delete(@PathVariable("id") int id) {
    return _replyService.delete(id);
  }

}
