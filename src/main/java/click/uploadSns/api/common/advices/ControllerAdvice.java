package click.uploadSns.api.common.advices;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import click.uploadSns.api.domain.exceptions.InvalidInputException;
import click.uploadSns.api.domain.models.Dtos.ErrorMessage;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(InvalidInputException.class)
  @ResponseBody
  public ErrorMessage handleException(InvalidInputException e) {
    return new ErrorMessage(e.getMessage());
  }

}
