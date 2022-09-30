package click.uploadSns.api.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import click.uploadSns.api.domain.models.User;
import click.uploadSns.api.domain.models.Dtos.UserDto;
import click.uploadSns.api.domain.repositories.UserMapper;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  private final UserMapper _userMapper;

  UserServiceImpl(UserMapper userMapper) {
    this._userMapper = userMapper;
  }

  @Override
  public List<UserDto> findAll() {
    return _userMapper.findAll();
  }

  @Override
  public UserDto findById(int id) {
    Optional<UserDto> userOpt = _userMapper.findById(id);
    return userOpt.get();
  }

  @Override
  public UserDto findByUserName(String username) {
    Optional<UserDto> userOpt = _userMapper.findByUserName(username);
    return userOpt.get();
  }

  @Override
  public UserDto findByCognitoId(String cognitoId) {
    Optional<UserDto> userOpt = _userMapper.findByCognitoId(cognitoId);
    return userOpt.get();
  }

  @Override
  public UserDto insert(User user) {
    _userMapper.insert(user);
    return _userMapper.findById(user.getId()).get();
  }

  @Override
  public UserDto update(User user) {
    _userMapper.update(user);
    return _userMapper.findById(user.getId()).get();
  }

  @Override
  public int delete(int id) {
    _userMapper.delete(id);
    return id;
  }

}
