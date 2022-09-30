// package click.uploadSns.api.domain.repositories;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.context.jdbc.Sql;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// import click.uploadSns.api.domain.models.Image;

// @ExtendWith(SpringExtension.class)
// @MybatisTest
// public class ImageMapperTest {

// @Autowired
// private ImageMapper _imageMapper;

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void findByIdTest() {
// var res1 = _imageMapper.findById(1111);
// Assertions.assertTrue(res1.isEmpty());
// var res2 = _imageMapper.findById(400);
// Assertions.assertTrue(res2.isPresent());
// Assertions.assertTrue(!res2.get().getArticle().getTitle().isEmpty());
// }

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void findAllTest() {
// var res = this._imageMapper.findAll();
// Assertions.assertEquals(1, res.size());
// res.forEach(img -> {
// Assertions.assertTrue(!img.getImageFilePath().isEmpty());
// });
// }

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void insertTest() {
// Image input = new Image();
// input.setImageFilePath("SampleImageFilePath");
// input.setArticleId(300);
// this._imageMapper.insert(input);
// var res1 = this._imageMapper.findById(input.getId());
// Assertions.assertTrue(res1.isPresent());
// }

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void updateTest() {
// Image input = new Image();
// input.setImageFilePath("SampleImageFilePath");
// input.setArticleId(300);
// this._imageMapper.insert(input);
// var insertRes = this._imageMapper.findById(input.getId());
// Assertions.assertTrue(insertRes.isPresent());

// input.setImageFilePath("UpdatedImageFile");
// this._imageMapper.update(input);
// var updateRes = this._imageMapper.findById(input.getId());
// Assertions.assertNotEquals(insertRes.get().getImageFilePath(),
// updateRes.get().getImageFilePath());
// }

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void deleteTest() {
// Image input = new Image();
// input.setImageFilePath("SampleImageFile");
// input.setArticleId(300);
// this._imageMapper.insert(input);
// var insertRes = this._imageMapper.findById(input.getId());
// Assertions.assertTrue(insertRes.isPresent());

// this._imageMapper.delete(input.getId());
// var deleteRes = this._imageMapper.findById(input.getId());
// Assertions.assertTrue(deleteRes.isEmpty());
// }

// }
