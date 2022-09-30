package click.uploadSns.api.domain.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import click.uploadSns.api.domain.models.Reply;

@ExtendWith(SpringExtension.class)
@MybatisTest
public class ReplyMapperTest {

    @Autowired
    private ReplyMapper _replyMapper;

    @Test
    @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
    public void findByIdTest() {
        var res = this._replyMapper.findById(600);
        Assertions.assertEquals(2, res.size());
        res.forEach(art -> {
            Assertions.assertTrue(!art.getUser().getName().isEmpty());
            Assertions.assertTrue(!art.getArticle().getUser().getName().isEmpty());
        });
    }

    @Test
    @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
    public void findAllTest() {
        var res = this._replyMapper.findAll();
        Assertions.assertEquals(3, res.size());
        res.forEach(art -> {
            Assertions.assertTrue(!art.getUser().getName().isEmpty());
            Assertions.assertTrue(!art.getArticle().getUser().getName().isEmpty());
        });
    }

    @Test
    @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
    public void findByArticleIdTest() {
        var res = this._replyMapper.findByArticleId(302);
        Assertions.assertEquals(2, res.size());
        res.forEach(art -> {
            Assertions.assertTrue(!art.getUser().getName().isEmpty());
            Assertions.assertTrue(!art.getArticle().getUser().getName().isEmpty());
        });
    }

    @Test
    @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
    public void insertTest() {
        Reply input = new Reply();
        input.setComment("SampleTitle");
        input.setUserId(100);
        input.setParentId(600);
        input.setArticleId(303);
        this._replyMapper.insert(input);
        var res1 = this._replyMapper.findById(input.getId());
        Assertions.assertTrue(!res1.isEmpty());
    }

    @Test
    @Sql(scripts = { "classpath:DDL/schema.sql", "classpath:DML/data.sql" })
    public void deleteTest() {
        Reply input = new Reply();
        input.setComment("SampleComment");
        input.setUserId(100);
        input.setParentId(600);
        input.setArticleId(303);
        this._replyMapper.insert(input);
        var insertRes = this._replyMapper.findById(input.getId());
        Assertions.assertTrue(!insertRes.isEmpty());

        this._replyMapper.delete(input.getId());
        var deleteRes = this._replyMapper.findById(input.getId());
        Assertions.assertTrue(deleteRes.isEmpty());
    }

}
