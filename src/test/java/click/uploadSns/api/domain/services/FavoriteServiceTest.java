package click.uploadSns.api.domain.services;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import click.uploadSns.api.domain.models.Favorite;
import click.uploadSns.api.domain.models.Dtos.FavoriteDto;
import click.uploadSns.api.domain.models.Dtos.UserDto;
import click.uploadSns.api.domain.repositories.FavoriteMapper;

@ExtendWith(SpringExtension.class)
@MybatisTest
public class FavoriteServiceTest {

  @Mock
  private FavoriteMapper _favoriteMapper;

  @InjectMocks
  private FavoriteServiceImpl _favoriteServiceImpl;

  @Test
  public void findAllTest() {

    List<FavoriteDto> mockList = new ArrayList<>();
    FavoriteDto favoriteDto = new FavoriteDto();
    mockList.add(favoriteDto);
    mockList.add(favoriteDto);

    when(_favoriteMapper.findAll()).thenReturn(mockList);

    List<FavoriteDto> resList = _favoriteServiceImpl.findAll();

    verify(_favoriteMapper, times(1)).findAll();

    Assertions.assertEquals(mockList.size(), resList.size());
  }

  @Test
  public void findByIdTest() {

    FavoriteDto favDto = new FavoriteDto();

    when(_favoriteMapper.findById(123)).thenReturn(Optional.of(favDto));

    FavoriteDto resDto = _favoriteServiceImpl.findById(123);

    verify(_favoriteMapper, times(1)).findById(123);

    Assertions.assertEquals(favDto, resDto);
  }

  @Test
  public void findByPushUserIdTest() {

    List<FavoriteDto> mockList = new ArrayList<>();
    UserDto userDto = new UserDto();
    userDto.setId(123);
    FavoriteDto favoriteDto = new FavoriteDto();
    favoriteDto.setPushUser(userDto);
    mockList.add(favoriteDto);

    when(_favoriteMapper.findByPushUserId(123)).thenReturn(mockList);

    List<FavoriteDto> resList = _favoriteServiceImpl.findByPushUserId(123);

    verify(_favoriteMapper, times(1)).findByPushUserId(123);

    Assertions.assertEquals(mockList.get(0).getPushUser().getId(), resList.get(0).getPushUser().getId());
  }

  @Test
  public void insertTest() {

    Favorite fav = new Favorite();
    FavoriteDto favDto = new FavoriteDto();
    fav.setId(123);
    favDto.setId(123);

    doNothing().when(_favoriteMapper).insert(fav);

    when(_favoriteMapper.findById(123)).thenReturn(Optional.of(favDto));

    var res = _favoriteServiceImpl.insert(fav);

    verify(_favoriteMapper, times(1)).insert(fav);

    Assertions.assertEquals(123, res.getId());
  }

  @Test
  public void updateTest() {

    Favorite fav = new Favorite();
    FavoriteDto favDto = new FavoriteDto();
    fav.setId(123);
    favDto.setId(123);

    doNothing().when(_favoriteMapper).update(fav);

    when(_favoriteMapper.findById(123)).thenReturn(Optional.of(favDto));

    var res = _favoriteServiceImpl.update(fav);

    verify(_favoriteMapper, times(1)).update(fav);

    Assertions.assertEquals(123, res.getId());
  }

  @Test
  public void deleteTest() {

    doNothing().when(_favoriteMapper).delete(123);

    int resId = _favoriteServiceImpl.delete(123);

    verify(_favoriteMapper, times(1)).delete(123);

    Assertions.assertEquals(123, resId);
  }

}
