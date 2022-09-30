// package click.uploadSns.api.common.aspects;

// import javax.servlet.http.HttpServletRequest;

// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.springframework.stereotype.Component;
// import org.springframework.web.context.request.RequestContextHolder;
// import org.springframework.web.context.request.ServletRequestAttributes;

// import click.uploadSns.api.domain.models.AccessLog;
// import click.uploadSns.api.domain.services.AccessLogServiceImpl;
// import lombok.RequiredArgsConstructor;

// @Aspect
// @Component
// @RequiredArgsConstructor
// public class AccessLogAspect {

// private final AccessLogServiceImpl _accessLogServiceImpl;

// @Before("execution(* click.uploadSns.api.common.controllers.*.*(..))")
// public void accessLog() {
// AccessLog input = new AccessLog();
// HttpServletRequest request = ((ServletRequestAttributes)
// RequestContextHolder.getRequestAttributes()).getRequest();
// System.out.println("リクエストURL:" + "/" +
// request.getRequestURL().toString().split("/", 4)[3]);
// input.setAccessUri("/" + request.getRequestURL().toString().split("/",
// 4)[3]);
// input.setUserId(Integer.parseInt(request.getRemoteUser()));
// _accessLogServiceImpl.insert(input);
// }
// }
