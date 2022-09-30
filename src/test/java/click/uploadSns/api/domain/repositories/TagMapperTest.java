// package click.uploadSns.api.domain.repositories;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.context.jdbc.Sql;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// import click.uploadSns.api.domain.models.Tag;

// @ExtendWith(SpringExtension.class)
// @MybatisTest
// public class TagMapperTest {

// @Autowired
// private TagMapper _tagMapper;

// // @Test
// // @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// // public void findByIdTest() {
// // var res1 = _tagMapper.findById(1111);
// // Assertions.assertTrue(res1.isEmpty());
// // var res2 = _tagMapper.findById(500);
// // Assertions.assertTrue(res2.isPresent());
// // Assertions.assertTrue(!res2.get().getName().isEmpty());
// // }

// // @Test
// // @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// // public void findAllTest() {
// // var res = this._tagMapper.findAll();
// // Assertions.assertEquals(2, res.size());
// // res.forEach(tag -> {
// // Assertions.assertTrue(!tag.getName().isEmpty());
// // });
// // }

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void insertTest() {
// Tag input = new Tag();
// input.setName("SampleBody");
// this._tagMapper.insert(input);
// var res1 = this._tagMapper.findById(input.getId());
// Assertions.assertTrue(res1.isPresent());
// }

// // @Test
// // @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// // public void updateTest() {
// // Tag input = new Tag();
// // input.setName("SampleTitle");
// // this._tagMapper.insert(input);
// // var insertRes = this._tagMapper.findById(input.getId());
// // Assertions.assertTrue(insertRes.isPresent());

// // input.setName("UpdateTitle");
// // this._tagMapper.update(input);
// // var updateRes = this._tagMapper.findById(input.getId());
// // Assertions.assertNotEquals(insertRes.get().getName(),
// // updateRes.get().getName());
// // }

// // @Test
// // @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// // public void deleteTest() {
// // Tag input = new Tag();
// // input.setName("SampleTitle");
// // this._tagMapper.insert(input);
// // var insertRes = this._tagMapper.findById(input.getId());
// // Assertions.assertTrue(insertRes.isPresent());

// // this._tagMapper.delete(input.getId());
// // var deleteRes = this._tagMapper.findById(input.getId());
// // Assertions.assertTrue(deleteRes.isEmpty());
// // }

// }
