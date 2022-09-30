// package click.uploadSns.api.domain.repositories;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.context.jdbc.Sql;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// import click.uploadSns.api.domain.models.Article;

// @ExtendWith(SpringExtension.class)
// @MybatisTest
// public class ArticleMapperTest {

// @Autowired
// private ArticleMapper _articleMapper;

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void findByIdTest() {
// var res1 = _articleMapper.findById(1111);
// Assertions.assertTrue(res1.isEmpty());
// var res2 = _articleMapper.findById(300);
// Assertions.assertTrue(res2.isPresent());
// Assertions.assertTrue(!res2.get().getUser().getName().isEmpty());
// Assertions.assertTrue(!res2.get().getTags().get(0).getName().isEmpty());
// Assertions.assertTrue(!res2.get().getImage().getImageFilePath().isEmpty());
// }

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void findAllTest() {
// var res = this._articleMapper.findAll();
// Assertions.assertEquals(11, res.size());
// res.forEach(art -> {
// Assertions.assertTrue(!art.getTitle().isEmpty());
// // Assertions.assertTrue(!art.getTags().get(0).getName().isEmpty());
// });
// }

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void findByUserIdTest() {
// var res1 = _articleMapper.findByUserId(1111);
// Assertions.assertTrue(res1.isEmpty());
// var res2 = _articleMapper.findByUserId(100);
// Assertions.assertTrue(!res2.isEmpty());
// Assertions.assertTrue(!res2.get(0).getUser().getName().isEmpty());
// Assertions.assertTrue(!res2.get(0).getTags().get(0).getName().isEmpty());
// }

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void searchByTitleTest() {
// var res1 = this._articleMapper.searchByTitle("aaaa");
// Assertions.assertTrue(res1.isEmpty());
// var res2 = _articleMapper.searchByTitle("Test");
// Assertions.assertTrue(!res2.isEmpty());
// Assertions.assertTrue(!res2.get(0).getUser().getName().isEmpty());
// Assertions.assertTrue(!res2.get(9).getTags().get(0).getName().isEmpty());
// };

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void searchByTagNameTest() {
// var res1 = this._articleMapper.searchByTagName("aaaa");
// Assertions.assertTrue(res1.isEmpty());
// var res2 = _articleMapper.searchByTagName("TestName2");
// Assertions.assertTrue(!res2.isEmpty());
// Assertions.assertTrue(!res2.get(0).getUser().getName().isEmpty());
// Assertions.assertTrue(!res2.get(0).getTags().get(0).getName().isEmpty());
// };

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void insertTest() {
// Article input = new Article();
// input.setTitle("SampleTitle");
// input.setBody("SampleBody");
// input.setUserId(100);
// this._articleMapper.insert(input);
// var res1 = this._articleMapper.findById(input.getId());
// Assertions.assertTrue(res1.isPresent());
// }

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void updateTest() {
// Article input = new Article();
// input.setTitle("SampleTitle");
// input.setBody("SampleBody");
// input.setUserId(100);
// this._articleMapper.insert(input);
// var insertRes = this._articleMapper.findById(input.getId());
// Assertions.assertTrue(insertRes.isPresent());

// input.setTitle("UpdateTitle");
// this._articleMapper.update(input);
// var updateRes = this._articleMapper.findById(input.getId());
// Assertions.assertNotEquals(insertRes.get().getTitle(),
// updateRes.get().getTitle());
// }

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void deleteTest() {
// Article input = new Article();
// input.setTitle("SampleTitle");
// input.setBody("SampleBody");
// input.setUserId(100);
// this._articleMapper.insert(input);
// var insertRes = this._articleMapper.findById(input.getId());
// Assertions.assertTrue(insertRes.isPresent());

// this._articleMapper.delete(input.getId());
// var deleteRes = this._articleMapper.findById(input.getId());
// Assertions.assertTrue(deleteRes.isEmpty());
// }

// }
