package click.uploadSns.api.domain.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import click.uploadSns.api.domain.models.Favorite;

@ExtendWith(SpringExtension.class)
@MybatisTest
public class FavoriteMapperTest {

  @Autowired
  private FavoriteMapper _favoriteMapper;

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void findByIdTest() {
    var res1 = _favoriteMapper.findById(1111);
    Assertions.assertTrue(res1.isEmpty());
    var res2 = _favoriteMapper.findById(200);
    Assertions.assertTrue(res2.isPresent());
    Assertions.assertTrue(!res2.get().getArticle().getTitle().isEmpty());
  }

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void findAllTest() {
    var res = this._favoriteMapper.findAll();
    Assertions.assertEquals(1, res.size());
    res.forEach(fav -> {
      Assertions.assertTrue(!fav.getPushUser().getName().isEmpty());
    });
  }

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void findByPushUserId() {
    var res1 = _favoriteMapper.findByPushUserId(1111);
    Assertions.assertTrue(res1.isEmpty());
    var res2 = _favoriteMapper.findByPushUserId(100);
    Assertions.assertTrue(!res2.isEmpty());
    Assertions.assertTrue(!res2.get(0).getArticle().getTitle().isEmpty());
  }

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void insertTest() {
    Favorite input = new Favorite();
    input.setPushUserId(100);
    input.setArticleId(300);
    this._favoriteMapper.insert(input);
    var res1 = this._favoriteMapper.findById(input.getId());
    Assertions.assertTrue(res1.isPresent());
  }

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void updateTest() {
    Favorite input = new Favorite();
    input.setPushUserId(100);
    input.setArticleId(300);
    this._favoriteMapper.insert(input);
    var insertRes = this._favoriteMapper.findById(input.getId());
    Assertions.assertTrue(insertRes.isPresent());

    input.setPushUserId(700);
    this._favoriteMapper.update(input);
    var updateRes = this._favoriteMapper.findById(input.getId());
    Assertions.assertNotEquals(insertRes.get().getPushUser(),
        updateRes.get().getPushUser());
  }

  @Test
  @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
  public void deleteTest() {
    Favorite input = new Favorite();
    input.setPushUserId(100);
    input.setArticleId(300);
    this._favoriteMapper.insert(input);
    var insertRes = this._favoriteMapper.findById(input.getId());
    Assertions.assertTrue(insertRes.isPresent());

    this._favoriteMapper.delete(input.getId());
    var deleteRes = this._favoriteMapper.findById(input.getId());
    Assertions.assertTrue(deleteRes.isEmpty());
  }

}