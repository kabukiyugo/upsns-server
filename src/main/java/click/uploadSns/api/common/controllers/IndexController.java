package click.uploadSns.api.common.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin 
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {

  @GetMapping
  public String getIndex() {
    return "index";
  }

    
}
