package click.uploadSns.api.domain.services;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import click.uploadSns.api.domain.models.Reply;
import click.uploadSns.api.domain.models.Dtos.ArticleDto;
import click.uploadSns.api.domain.models.Dtos.ReplyDto;
import click.uploadSns.api.domain.models.Dtos.SaveReplyDataDto;
import click.uploadSns.api.domain.repositories.ReplyMapper;

@ExtendWith(SpringExtension.class)
@MybatisTest
public class ReplyServiceTest {

  @Mock
  private ReplyMapper _replyMapper;

  @InjectMocks
  private ReplyServiceImpl _replyServiceImpl;

  @Test
  public void findAllTest() {

    List<SaveReplyDataDto> mockList = new ArrayList<>();

    SaveReplyDataDto saveReplyData1 = new SaveReplyDataDto();
    saveReplyData1.setId(100);
    mockList.add(saveReplyData1);

    SaveReplyDataDto saveReplyData2 = new SaveReplyDataDto();
    saveReplyData2.setId(101);
    mockList.add(saveReplyData2);

    SaveReplyDataDto saveReplyData3 = new SaveReplyDataDto();
    saveReplyData3.setId(102);
    saveReplyData3.setParentId(101);
    mockList.add(saveReplyData3);

    SaveReplyDataDto saveReplyData4 = new SaveReplyDataDto();
    saveReplyData4.setId(103);
    saveReplyData4.setParentId(102);
    mockList.add(saveReplyData4);

    SaveReplyDataDto saveReplyData5 = new SaveReplyDataDto();
    saveReplyData5.setId(104);
    saveReplyData5.setParentId(102);
    mockList.add(saveReplyData5);

    when(_replyMapper.findAll()).thenReturn(mockList);

    List<ReplyDto> resList = _replyServiceImpl.findAll();

    verify(_replyMapper, times(1)).findAll();

    Assertions.assertEquals(2, resList.size());

    Assertions.assertEquals(saveReplyData3.getId(), resList.get(1).getChildrenReply().get(0).getId());

    Assertions.assertEquals(2, resList.get(1).getChildrenReply().get(0).getChildrenReply().size());
  }

  @Test
  public void findByIdTest() {

    List<SaveReplyDataDto> mockList = new ArrayList<>();

    SaveReplyDataDto saveReplyData1 = new SaveReplyDataDto();
    saveReplyData1.setId(100);
    mockList.add(saveReplyData1);

    SaveReplyDataDto saveReplyData2 = new SaveReplyDataDto();
    saveReplyData2.setId(101);
    mockList.add(saveReplyData2);

    SaveReplyDataDto saveReplyData3 = new SaveReplyDataDto();
    saveReplyData3.setId(102);
    saveReplyData3.setParentId(101);
    mockList.add(saveReplyData3);

    SaveReplyDataDto saveReplyData4 = new SaveReplyDataDto();
    saveReplyData4.setId(103);
    saveReplyData4.setParentId(102);
    mockList.add(saveReplyData4);

    SaveReplyDataDto saveReplyData5 = new SaveReplyDataDto();
    saveReplyData5.setId(104);
    saveReplyData5.setParentId(102);
    mockList.add(saveReplyData5);

    when(_replyMapper.findById(101)).thenReturn(mockList);

    ReplyDto result1 = _replyServiceImpl.findById(101);

    verify(_replyMapper, times(1)).findById(101);

    Assertions.assertEquals(saveReplyData3.getId(),
        result1.getChildrenReply().get(0).getId());

    Assertions.assertEquals(2,
        result1.getChildrenReply().get(0).getChildrenReply().size());

    when(_replyMapper.findById(102)).thenReturn(mockList);

    ReplyDto result2 = _replyServiceImpl.findById(102);

    verify(_replyMapper, times(1)).findById(102);

    Assertions.assertEquals(2, result2.getChildrenReply().size());
  }

  @Test
  public void findByArticleIdTest() {

    List<SaveReplyDataDto> mockList = new ArrayList<>();
    ArticleDto articleDto = new ArticleDto();
    articleDto.setId(999);

    SaveReplyDataDto saveReplyData1 = new SaveReplyDataDto();
    saveReplyData1.setId(100);
    saveReplyData1.setArticle(articleDto);
    mockList.add(saveReplyData1);

    SaveReplyDataDto saveReplyData2 = new SaveReplyDataDto();
    saveReplyData2.setId(101);
    saveReplyData2.setArticle(articleDto);
    mockList.add(saveReplyData2);

    SaveReplyDataDto saveReplyData3 = new SaveReplyDataDto();
    saveReplyData3.setId(102);
    saveReplyData3.setParentId(101);
    saveReplyData3.setArticle(articleDto);
    mockList.add(saveReplyData3);

    SaveReplyDataDto saveReplyData4 = new SaveReplyDataDto();
    saveReplyData4.setId(103);
    saveReplyData4.setParentId(102);
    saveReplyData4.setArticle(articleDto);
    mockList.add(saveReplyData4);

    when(_replyMapper.findByArticleId(999)).thenReturn(mockList);

    List<ReplyDto> resList = _replyServiceImpl.findByArticleId(999);

    verify(_replyMapper, times(1)).findByArticleId(999);

    Assertions.assertEquals(2, resList.size());

    Assertions.assertEquals(saveReplyData3.getId(), resList.get(1).getChildrenReply().get(0).getId());

    Assertions.assertEquals(1, resList.get(1).getChildrenReply().get(0).getChildrenReply().size());
  }

  @Test
  public void insertTest() {

    Reply rep1 = new Reply();
    rep1.setId(123);
    rep1.setParentId(0);
    rep1.setArticleId(100);

    List<SaveReplyDataDto> mockList1 = new ArrayList<>();
    SaveReplyDataDto saveReplyDataDto1 = new SaveReplyDataDto();
    saveReplyDataDto1.setId(123);
    mockList1.add(saveReplyDataDto1);

    doNothing().when(_replyMapper).insertWithoutParent(rep1);

    when(_replyMapper.findById(123)).thenReturn(mockList1);

    var res1 = _replyServiceImpl.insert(rep1);

    verify(_replyMapper, times(1)).insertWithoutParent(rep1);

    Assertions.assertEquals(123, res1.getId());

    Reply rep2 = new Reply();
    rep2.setId(456);
    rep2.setParentId(999);
    rep1.setArticleId(100);

    List<SaveReplyDataDto> mockList2 = new ArrayList<>();
    SaveReplyDataDto saveReplyDataDto2 = new SaveReplyDataDto();
    saveReplyDataDto2.setId(456);
    mockList2.add(saveReplyDataDto2);

    doNothing().when(_replyMapper).insert(rep2);

    when(_replyMapper.findById(456)).thenReturn(mockList2);

    var res2 = _replyServiceImpl.insert(rep2);

    verify(_replyMapper, times(1)).insert(rep2);

    Assertions.assertEquals(456, res2.getId());
  }

  @Test
  public void deleteTest() {

    doNothing().when(_replyMapper).delete(123);

    int resId = _replyServiceImpl.delete(123);

    verify(_replyMapper, times(1)).delete(123);

    Assertions.assertEquals(123, resId);
  }

}
