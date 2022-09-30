// package click.uploadSns.api.domain.services;

// import static org.mockito.Mockito.doNothing;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// import click.uploadSns.api.domain.models.AccessLog;
// import click.uploadSns.api.domain.repositories.AccessLogMapper;

// @ExtendWith(SpringExtension.class)
// @MybatisTest
// public class AccessLogServiceTest {

// @Mock
// private AccessLogMapper _accessLogMapper;

// @InjectMocks
// private AccessLogServiceImpl _accessLogServiceImpl;

// @Test
// public void insertTest() {

// AccessLog log = new AccessLog();
// log.setId(1);
// doNothing().when(_accessLogMapper).insert(log);
// var res1 = _accessLogServiceImpl.insert(log);
// Assertions.assertEquals(1, res1);
// verify(_accessLogMapper, times(1)).insert(log);

// }

// }
