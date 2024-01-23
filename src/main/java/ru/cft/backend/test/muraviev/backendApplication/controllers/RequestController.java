package ru.cft.backend.test.muraviev.backendApplication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.backend.test.muraviev.backendApplication.intervals.Interval;

@RestController
@RequestMapping("/intervals")
public class RequestController {

  @GetMapping("/min")
  public String getMinimal(@RequestParam("type") String type, ){

  }
}
