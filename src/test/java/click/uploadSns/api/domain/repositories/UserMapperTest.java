package click.uploadSns.api.domain.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import click.uploadSns.api.domain.models.User;

@ExtendWith(SpringExtension.class)
@MybatisTest
public class UserMapperTest {

  @Autowired
  private UserMapper _userMapper;

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void findByIdTest() {
    var res1 = _userMapper.findById(1111);
    Assertions.assertTrue(res1.isEmpty());
    var res2 = _userMapper.findById(100);
    Assertions.assertTrue(res2.isPresent());
    Assertions.assertTrue(!res2.get().getName().isEmpty());
  }

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void findAllTest() {
    var res = this._userMapper.findAll();
    Assertions.assertEquals(2, res.size());
    res.forEach(usr -> {
      Assertions.assertTrue(!usr.getName().isEmpty());
    });
  }

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void findByUserNameTest() {
    var res1 = _userMapper.findByUserName("a");
    Assertions.assertTrue(res1.isEmpty());
    var res2 = _userMapper.findByUserName("TestName");
    Assertions.assertTrue(res2.isPresent());
    Assertions.assertTrue(!res2.get().getName().isEmpty());
  }

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void findByCognitoIdTest() {
    var res1 = _userMapper.findByCognitoId("a");
    Assertions.assertTrue(res1.isEmpty());
    var res2 = _userMapper.findByCognitoId("Test-Name");
    Assertions.assertTrue(res2.isPresent());
    Assertions.assertTrue(!res2.get().getName().isEmpty());
  }

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void insertTest() {
    User input = new User();
    input.setName("SampleName");
    input.setFurigana("SampleFurigana");
    input.setMail("SampleMail");
    input.setTelNo("SampleTelNo");
    input.setPassword("SamplePassword");
    input.setIconImagePath("SampleIconImagePath");
    input.setCognitoId("SampleId");
    this._userMapper.insert(input);
    var res1 = this._userMapper.findById(input.getId());
    Assertions.assertTrue(res1.isPresent());
  }

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void updateTest() {
    User input = new User();
    input.setName("SampleName");
    input.setFurigana("SampleFurigana");
    input.setMail("SampleMail");
    input.setTelNo("SampleTelNo");
    input.setPassword("SamplePassword");
    input.setIconImagePath("SampleIconImagePath");
    input.setCognitoId("SampleId");
    this._userMapper.insert(input);
    var insertRes = this._userMapper.findById(input.getId());
    Assertions.assertTrue(insertRes.isPresent());

    input.setName("UpdatedName");
    this._userMapper.update(input);
    var updateRes = this._userMapper.findById(input.getId());
    Assertions.assertNotEquals(insertRes.get().getName(),
        updateRes.get().getName());
  }

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void deleteTest() {
    User input = new User();
    input.setName("SampleName");
    input.setFurigana("SampleFurigana");
    input.setMail("SampleMail");
    input.setTelNo("SampleTelNo");
    input.setPassword("SamplePassword");
    input.setIconImagePath("SampleIconImagePath");
    input.setCognitoId("SampleId");
    this._userMapper.insert(input);
    var insertRes = this._userMapper.findById(input.getId());
    Assertions.assertTrue(insertRes.isPresent());

    this._userMapper.delete(input.getId());
    var deleteRes = this._userMapper.findById(input.getId());
    Assertions.assertTrue(deleteRes.isEmpty());
  }

}
