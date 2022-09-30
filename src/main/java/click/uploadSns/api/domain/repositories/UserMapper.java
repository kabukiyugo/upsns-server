package click.uploadSns.api.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import click.uploadSns.api.domain.models.User;
import click.uploadSns.api.domain.models.Dtos.UserDto;

@Mapper
public interface UserMapper {

    List<UserDto> findAll();

    Optional<UserDto> findById(int id);

    public void insert(User user);

    public void update(User user);

    public void delete(int id);

    public Optional<UserDto> findByUserName(String userName);

    public Optional<UserDto> findByCognitoId(String cognitoId);

}
