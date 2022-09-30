package click.uploadSns.api.domain.services;

import java.util.List;

import click.uploadSns.api.domain.models.User;
import click.uploadSns.api.domain.models.Dtos.UserDto;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(int id);

    UserDto insert(User user);

    UserDto update(User user);

    int delete(int id);

    UserDto findByUserName(String username);

    UserDto findByCognitoId(String cognitoId);

}
