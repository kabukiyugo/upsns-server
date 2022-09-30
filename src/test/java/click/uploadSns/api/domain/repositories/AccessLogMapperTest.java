// package click.uploadSns.api.domain.repositories;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.context.jdbc.Sql;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// import click.uploadSns.api.domain.models.AccessLog;

// @ExtendWith(SpringExtension.class)
// @MybatisTest
// public class AccessLogMapperTest {
// @Autowired
// private AccessLogMapper _accessLogMapper;

// @Test
// @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
// public void insertTest() {
// AccessLog input = new AccessLog();
// input.setAccessUri("SampleTitle");
// input.setUserId(100);
// this._accessLogMapper.insert(input);
// Assertions.assertNotEquals(0, input.getId());
// }

// }
