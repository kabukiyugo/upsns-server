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

// import click.uploadSns.api.domain.models.Article;
// import click.uploadSns.api.domain.models.Tag;
// import click.uploadSns.api.domain.models.Dtos.ArticleDto;
// import click.uploadSns.api.domain.models.Dtos.DisplayDto;
// import click.uploadSns.api.domain.models.Dtos.FavoriteDto;
// import click.uploadSns.api.domain.models.Dtos.TagDto;
// import click.uploadSns.api.domain.repositories.ArticleMapper;
// import click.uploadSns.api.domain.repositories.FavoriteMapper;

// @ExtendWith(SpringExtension.class)
// @MybatisTest
// public class ArticleServiceTest {

// @Mock
// private ArticleMapper _articleMapper;

// @Mock
// private FavoriteMapper _favoriteMapper;

// @InjectMocks
// private ArticleServiceImpl _articleServiceImpl;

// @Test
// public void findAllTest() {

// List<ArticleDto> mockList = new ArrayList<>();
// ArticleDto articleDto = new ArticleDto();
// mockList.add(articleDto);
// mockList.add(articleDto);

// when(_articleMapper.findAll()).thenReturn(mockList);

// List<ArticleDto> resList = _articleServiceImpl.findAll();

// verify(_articleMapper, times(1)).findAll();

// Assertions.assertEquals(mockList.size(), resList.size());
// }

// @Test
// public void findByIdTest() {

// ArticleDto artDto = new ArticleDto();

// when(_articleMapper.findById(123)).thenReturn(Optional.of(artDto));

// ArticleDto resDto = _articleServiceImpl.findById(123);

// verify(_articleMapper, times(1)).findById(123);

// Assertions.assertEquals(artDto, resDto);
// }

// @Test
// public void searchArtAndFavTest() {

// List<ArticleDto> artList = new ArrayList<>();
// ArticleDto articleDto = new ArticleDto();
// articleDto.setId(111);
// artList.add(articleDto);

// List<FavoriteDto> favList = new ArrayList<>();
// FavoriteDto favoriteDto = new FavoriteDto();
// favoriteDto.setArticle(articleDto);
// favList.add(favoriteDto);

// when(_articleMapper.getTheLatest()).thenReturn(artList);

// when(_favoriteMapper.findByPushUserId(111)).thenReturn(favList);

// List<DisplayDto> resList = _articleServiceImpl.searchArtAndFav(111);

// verify(_articleMapper, times(1)).getTheLatest();

// verify(_favoriteMapper, times(1)).findByPushUserId(111);

// Assertions.assertEquals(111, resList.get(0).getArticle().getId());

// }

// @Test
// public void findByUserIdTest() {

// List<ArticleDto> artList = new ArrayList<>();

// ArticleDto articleDto = new ArticleDto();
// artList.add(articleDto);

// when(_articleMapper.findByUserId(123)).thenReturn(artList);

// List<ArticleDto> resList = _articleServiceImpl.findByUserId(123);

// verify(_articleMapper, times(1)).findByUserId(123);

// Assertions.assertEquals(artList.size(), resList.size());
// }

// @Test
// public void searchByTitle() {

// List<ArticleDto> artList = new ArrayList<>();

// ArticleDto articleDto = new ArticleDto();
// articleDto.setTitle("aaa");
// artList.add(articleDto);

// when(_articleMapper.searchByTitle("aaa")).thenReturn(artList);

// List<ArticleDto> resList = _articleServiceImpl.searchByTitle("aaa");

// verify(_articleMapper, times(1)).searchByTitle("aaa");

// Assertions.assertEquals(artList.get(0).getTitle(),
// resList.get(0).getTitle());
// }

// @Test
// public void searchByTagNameTest() {

// List<ArticleDto> artList = new ArrayList<>();
// ArticleDto articleDto = new ArticleDto();
// List<TagDto> tagList = new ArrayList<>();
// TagDto tagDto = new TagDto();
// tagDto.setName("aaa");
// tagList.add(tagDto);
// articleDto.setTags(tagList);
// artList.add(articleDto);

// when(_articleMapper.searchByTagName("aaa")).thenReturn(artList);

// List<ArticleDto> resList = _articleServiceImpl.searchByTagName("aaa");

// verify(_articleMapper, times(1)).searchByTagName("aaa");

// Assertions.assertEquals(artList.get(0).getTags().get(0).getName(),
// resList.get(0).getTags().get(0).getName());
// }

// @Test
// public void insertTest() {
// Tag tag = new Tag();
// tag.setId(456);
// tag.setName("test");
// List<Integer> tagList = new ArrayList<Integer>();
// tagList.add(456);

// TagDto tagDto = new TagDto();
// tagDto.setId(456);
// tagDto.setName("test");
// List<TagDto> tagDtoList = new ArrayList<TagDto>();
// tagDtoList.add(tagDto);

// Article art = new Article();
// ArticleDto artDto = new ArticleDto();
// art.setId(123);
// art.setTagIds(tagList);
// artDto.setId(123);
// artDto.setTags(tagDtoList);

// // mockの設定
// doNothing().when(_articleMapper).insert(art);

// doNothing().when(_articleMapper).addTag(123, 456);

// when(_articleMapper.findById(123)).thenReturn(Optional.of(artDto));

// // serviceの起動
// var res = _articleServiceImpl.insert(art);

// verify(_articleMapper, times(1)).insert(art);

// Assertions.assertEquals(123, res.getId());

// Assertions.assertEquals(456, res.getTags().get(0).getId());

// }

// @Test
// public void updateTest() {
// Tag tag = new Tag();
// tag.setId(456);
// tag.setName("test");
// List<Integer> tagList = new ArrayList<Integer>();
// tagList.add(456);

// TagDto tagDto = new TagDto();
// tagDto.setId(456);
// tagDto.setName("test");
// List<TagDto> tagDtoList = new ArrayList<TagDto>();
// tagDtoList.add(tagDto);

// Article art = new Article();
// ArticleDto artDto = new ArticleDto();
// art.setId(123);
// art.setTagIds(tagList);
// artDto.setId(123);
// artDto.setTags(tagDtoList);

// // mockの設定
// doNothing().when(_articleMapper).update(art);

// doNothing().when(_articleMapper).addTag(123, 456);

// when(_articleMapper.findById(123)).thenReturn(Optional.of(artDto));

// // serviceの起動
// var res = _articleServiceImpl.update(art);

// verify(_articleMapper, times(1)).update(art);

// Assertions.assertEquals(123, res.getId());

// Assertions.assertEquals(456, res.getTags().get(0).getId());
// }

// @Test
// public void deleteTest() {

// doNothing().when(_articleMapper).delete(123);

// int resId = _articleServiceImpl.delete(123);

// verify(_articleMapper, times(1)).delete(123);

// Assertions.assertEquals(123, resId);
// }

// }