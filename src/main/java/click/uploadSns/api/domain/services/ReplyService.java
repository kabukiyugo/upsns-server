package click.uploadSns.api.domain.services;

import java.util.List;

import click.uploadSns.api.domain.models.Reply;
import click.uploadSns.api.domain.models.Dtos.ReplyDto;

public interface ReplyService {

  List<ReplyDto> findAll();

  ReplyDto findById(int id);

  List<ReplyDto> findByArticleId(int articleId);

  ReplyDto insert(Reply reply);

  int delete(int id);

}
