// package click.uploadSns.api.domain.services;

// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import click.uploadSns.api.domain.models.AccessLog;
// import click.uploadSns.api.domain.repositories.AccessLogMapper;

// @Service
// @Transactional
// public class AccessLogServiceImpl implements AccessLogService {

// private final AccessLogMapper _accessLogMapper;

// public AccessLogServiceImpl(AccessLogMapper _accessLogMapper) {
// this._accessLogMapper = _accessLogMapper;
// }

// @Override
// public int insert(AccessLog accessLog) {

// try {
// _accessLogMapper.insert(accessLog);
// return accessLog.getId();
// } catch (RuntimeException e) {
// return 0;
// }

// }

// }
