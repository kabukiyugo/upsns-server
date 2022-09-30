package click.uploadSns.api.domain.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import click.uploadSns.api.domain.models.Reply;

import click.uploadSns.api.domain.models.Dtos.SaveReplyDataDto;

@Mapper
public interface ReplyMapper {

    List<SaveReplyDataDto> findAll();

    List<SaveReplyDataDto> findById(int id);

    List<SaveReplyDataDto> findByArticleId(int articleId);

    List<SaveReplyDataDto> findByUserId(int userId);

    List<SaveReplyDataDto> findByParentId(int parentId);

    public void insert(Reply reply);

    public void insertWithoutParent(Reply reply);

    public void delete(int id);

}
