// package click.uploadSns.api.domain.services;

// import static org.mockito.Mockito.doNothing;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// import click.uploadSns.api.domain.models.Tag;
// import click.uploadSns.api.domain.models.Dtos.TagDto;
// import click.uploadSns.api.domain.repositories.TagMapper;

// @ExtendWith(SpringExtension.class)
// @MybatisTest
// public class TagServiceTest {

// @Mock
// private TagMapper _tagMapper;

// @InjectMocks
// private TagServiceImpl _tagServiceImpl;

// @Test
// public void findAllTest() {

// List<TagDto> mockList = new ArrayList<>();
// TagDto tagDto = new TagDto();
// mockList.add(tagDto);
// mockList.add(tagDto);

// when(_tagMapper.findAll()).thenReturn(mockList);

// List<TagDto> resDto = _tagServiceImpl.findAll();

// verify(_tagMapper, times(1)).findAll();

// Assertions.assertEquals(mockList.size(), resDto.size());
// }

// @Test
// public void findByIdTest() {

// TagDto tagDto = new TagDto();

// when(_tagMapper.findById(123)).thenReturn(Optional.of(tagDto));

// TagDto resDto = _tagServiceImpl.findById(123);

// verify(_tagMapper, times(1)).findById(123);

// Assertions.assertEquals(tagDto, resDto);
// }

// @Test
// public void insertTest() {

// Tag tag = new Tag();
// TagDto tagDto = new TagDto();
// tag.setId(123);
// tagDto.setId(123);

// doNothing().when(_tagMapper).insert(tag);

// when(_tagMapper.findById(123)).thenReturn(Optional.of(tagDto));

// var res = _tagServiceImpl.insert(tag);

// verify(_tagMapper, times(1)).insert(tag);

// Assertions.assertEquals(123, res.getId());
// }

// @Test
// public void updateTest() {
// Tag tag = new Tag();
// TagDto tagDto = new TagDto();
// tag.setId(123);
// tagDto.setId(123);

// doNothing().when(_tagMapper).update(tag);

// when(_tagMapper.findById(123)).thenReturn(Optional.of(tagDto));

// var res = _tagServiceImpl.update(tag);

// verify(_tagMapper, times(1)).update(tag);

// Assertions.assertEquals(123, res.getId());
// }

// @Test
// public void deleteTest() {

// doNothing().when(_tagMapper).delete(123);

// int resId = _tagServiceImpl.delete(123);

// verify(_tagMapper, times(1)).delete(123);

// Assertions.assertEquals(123, resId);
// }

// }
