package click.uploadSns.api.domain.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import click.uploadSns.api.domain.models.Reply;
import click.uploadSns.api.domain.models.Dtos.ReplyDto;
import click.uploadSns.api.domain.models.Dtos.SaveReplyDataDto;
import click.uploadSns.api.domain.repositories.ArticleMapper;
import click.uploadSns.api.domain.repositories.ReplyMapper;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

  private final ReplyMapper _replyMapper;

  private final ArticleMapper _articleMapper;

  ReplyServiceImpl(ReplyMapper replyMapper, ArticleMapper articleMapper) {
    this._replyMapper = replyMapper;
    this._articleMapper = articleMapper;
  }

  @Override
  public List<ReplyDto> findAll() {
    List<SaveReplyDataDto> baseList = _replyMapper.findAll();
    // parentIdが0のデータだけのListを作る -> 大親だけのList
    var rootList = baseList.stream().filter(r -> r.getParentId() == 0).collect(Collectors.toList());
    return this._form(rootList, baseList);
  }

  @Override
  public ReplyDto findById(int id) {
    List<SaveReplyDataDto> baseList = _replyMapper.findById(id);
    // 親のidを元に、直下の子どもだけのListを作る
    var rootList = baseList.stream().filter(r -> r.getId() == id).collect(Collectors.toList());
    return this._form(rootList, baseList).get(0);
  }

  @Override
  public List<ReplyDto> findByArticleId(int articleId) {
    List<SaveReplyDataDto> baseList = _replyMapper.findByArticleId(articleId);
    var rootList = baseList.stream().filter(r -> r.getParentId() == 0).collect(Collectors.toList());
    return this._form(rootList, baseList);
  }

  @Override
  public List<ReplyDto> findByUserId(int userId) {
    List<SaveReplyDataDto> baseList = _replyMapper.findByUserId(userId);
    var rootList = baseList.stream().filter(r -> r.getParentId() == 0).collect(Collectors.toList());
    return this._form(rootList, baseList);
  }

  @Override
  public List<ReplyDto> findNotification(int userId) {
    var list = new ArrayList<ReplyDto>();
    var res1 = _articleMapper.findByUserId(userId);
    var res2 = _replyMapper.findByUserId(userId);
    res1.parallelStream().forEach(article -> {
      var res3 = this._replyMapper.findByArticleId(article.getId());
      res3.stream().filter(reply -> reply.getParentId() == 0).forEach(reply -> {
        var dto = new ReplyDto();
        dto.setId(reply.getId());
        dto.setComment(reply.getComment());
        dto.setArticle(reply.getArticle());
        dto.setInsertTime(reply.getInsertTime());
        dto.setUser(reply.getUser());
        list.add(dto);
      });
    });
    res2.parallelStream().forEach(parent -> {
      var res3 = this._replyMapper.findByParentId(parent.getId());
      res3.stream().filter(reply -> reply.getParentId() == 0).forEach(reply -> {
        var dto = new ReplyDto();
        dto.setId(reply.getId());
        dto.setComment(reply.getComment());
        dto.setArticle(reply.getArticle());
        dto.setInsertTime(reply.getInsertTime());
        dto.setUser(reply.getUser());
        list.add(dto);
      });
    });
    list.sort((a, b) -> new Date(a.getInsertTime()).before(new Date(b.getInsertTime())) ? 1 : -1);
    return list;
  }

  @Override
  public ReplyDto insert(Reply reply) {
    if (reply.getParentId() == 0) {
      _replyMapper.insertWithoutParent(reply);
    } else {
      _replyMapper.insert(reply);
    }
    List<SaveReplyDataDto> baseList = _replyMapper.findById(reply.getId());
    var rootList = baseList.stream().filter(r -> r.getId() == reply.getId()).collect(Collectors.toList());
    return this._form(rootList, baseList).get(0);
  }

  // メソッド切り出し 再帰的に処理
  private List<ReplyDto> _form(List<SaveReplyDataDto> parentList, List<SaveReplyDataDto> baseList) {
    List<ReplyDto> resultList = new ArrayList<ReplyDto>();

    for (SaveReplyDataDto r : parentList) {
      ReplyDto replyDto = new ReplyDto();
      // 親のidと同じparentIdを持つ子どもだけのリストを作る
      List<SaveReplyDataDto> childList = baseList.stream().filter(reply -> reply.getParentId() == r.getId())
          .collect(Collectors.toList());
      // 再帰的処理
      if (childList.size() != 0) {
        replyDto.setChildrenReply(_form(childList, baseList));
      }

      replyDto.setId(r.getId());
      replyDto.setComment(r.getComment());
      replyDto.setUser(r.getUser());
      replyDto.setInsertTime(r.getInsertTime());
      replyDto.setArticle(r.getArticle());
      resultList.add(replyDto);
    }

    return resultList;
  }

  @Override
  public int delete(int id) {
    _replyMapper.delete(id);
    return id;
  }

}
