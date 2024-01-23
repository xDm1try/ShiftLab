package ru.cft.backend.test.muraviev.backendApplication.controllers;

import org.springframework.web.bind.annotation.*;
import ru.cft.backend.test.muraviev.backendApplication.intervals.Interval;

@RestController
@RequestMapping("/intervals")
public class RequestController {

  @GetMapping("/min")
  public String getMinimal(@RequestParam("kind") String kind){
  return "";
  }

  @PostMapping("/merge")
  public void postIntervals(@RequestParam("kind") String kind, @RequestBody String data){
    switch (kind){
      case "digit" -> {

      }
      case "letter" -> {

      }
    }
  }
}
