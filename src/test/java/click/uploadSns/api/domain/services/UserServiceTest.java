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

import click.uploadSns.api.domain.models.User;
import click.uploadSns.api.domain.models.Dtos.UserDto;
import click.uploadSns.api.domain.repositories.UserMapper;

@ExtendWith(SpringExtension.class)
@MybatisTest
public class UserServiceTest {

  @Mock
  private UserMapper _userMapper;

  @InjectMocks
  private UserServiceImpl _userServiceImpl;

  @Test
  public void findAllTest() {

    List<UserDto> mockList = new ArrayList<>();
    UserDto userDto = new UserDto();
    mockList.add(userDto);
    mockList.add(userDto);

    when(_userMapper.findAll()).thenReturn(mockList);

    List<UserDto> resList = _userServiceImpl.findAll();

    verify(_userMapper, times(1)).findAll();

    Assertions.assertEquals(mockList.size(), resList.size());
  }

  @Test
  public void findByIdTest() {

    UserDto userDto = new UserDto();

    when(_userMapper.findById(123)).thenReturn(Optional.of(userDto));

    UserDto resDto = _userServiceImpl.findById(123);

    verify(_userMapper, times(1)).findById(123);

    Assertions.assertEquals(userDto, resDto);
  }

  @Test
  public void findByUserNameTest() {

    UserDto userDto = new UserDto();

    when(_userMapper.findByUserName("TestName")).thenReturn(Optional.of(userDto));

    UserDto resDto = _userServiceImpl.findByUserName("TestName");

    verify(_userMapper, times(1)).findByUserName("TestName");

    Assertions.assertEquals(userDto, resDto);
  }

  @Test
  public void findByVognitoIdTest() {

    UserDto userDto = new UserDto();

    when(_userMapper.findByCognitoId("Test-Name")).thenReturn(Optional.of(userDto));

    UserDto resDto = _userServiceImpl.findByCognitoId("Test-Name");

    verify(_userMapper, times(1)).findByCognitoId("Test-Name");

    Assertions.assertEquals(userDto, resDto);
  }

  @Test
  public void insertTest() {

    User user = new User();
    UserDto userDto = new UserDto();
    user.setId(123);
    userDto.setId(123);

    doNothing().when(_userMapper).insert(user);

    when(_userMapper.findById(123)).thenReturn(Optional.of(userDto));

    var res = _userServiceImpl.insert(user);

    verify(_userMapper, times(1)).insert(user);

    Assertions.assertEquals(123, res.getId());
  }

  @Test
  public void updateTest() {

    User user = new User();
    UserDto userDto = new UserDto();
    user.setId(123);
    userDto.setId(123);

    doNothing().when(_userMapper).update(user);

    when(_userMapper.findById(123)).thenReturn(Optional.of(userDto));

    var res = _userServiceImpl.update(user);

    verify(_userMapper, times(1)).update(user);

    Assertions.assertEquals(123, res.getId());
  }

  @Test
  public void deleteTest() {

    doNothing().when(_userMapper).delete(123);

    int resId = _userServiceImpl.delete(123);

    verify(_userMapper, times(1)).delete(123);

    Assertions.assertEquals(123, resId);
  }

}
