package ru.cft.backend.test.muraviev.backendApplication.controllers;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.web.bind.annotation.*;
import ru.cft.backend.test.muraviev.backendApplication.intervals.DigitsInterval;
import ru.cft.backend.test.muraviev.backendApplication.intervals.LettersInterval;
import ru.cft.backend.test.muraviev.backendApplication.services.DigitsIntervalService;
import ru.cft.backend.test.muraviev.backendApplication.services.IntervalsService;
import ru.cft.backend.test.muraviev.backendApplication.services.LettersIntervalService;
import ru.cft.backend.test.muraviev.backendApplication.services.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/intervals")
public class RequestController {
  private DigitsIntervalService digitsIntervalService;
  private LettersIntervalService lettersIntervalService;

  public RequestController(DigitsIntervalService digitsIntervalService, LettersIntervalService lettersIntervalService) {
    this.digitsIntervalService = digitsIntervalService;
    this.lettersIntervalService = lettersIntervalService;
  }

  @GetMapping("/min")
  public String getMinimal(@RequestParam("kind") String kind) {
    if (kind.equals("digits")) {
      IntervalsService intervalsService = new IntervalsService(digitsIntervalService);
      List<DigitsInterval> response = intervalsService.getMinimalDigitsInterval();
      if (response.isEmpty()) {
        return "";
      } else {
        return response.get(0).toString();
      }
    } else if (kind.equals("letters")) {
      IntervalsService intervalsService = new IntervalsService(lettersIntervalService);
      List<LettersInterval> response = intervalsService.getMinimalLettersInterval();
      if (response.isEmpty()) {
        return "";
      } else {
        return response.get(0).toString();
      }
    }
    return "";
  }

  @PostMapping("/merge")
  public void postIntervals(@RequestParam("kind") String kind, @RequestBody String data) throws ParseException {
    if (kind.equals("digits")) {
      ArrayList<DigitsInterval> digitsIntervalArray = JsonParser.jsonToDigitsIntervals(data);
      ArrayList<DigitsInterval> mergedDigitsIntervals = MergeIntervals.mergeDigitsIntervals(digitsIntervalArray);
      IntervalsService intervalsService = new IntervalsService(digitsIntervalService);
      intervalsService.saveDigitsIntervals(mergedDigitsIntervals);
    } else if (kind.equals("letters")) {
      ArrayList<LettersInterval> lettersIntervals = JsonParser.jsonToLetterIntervals(data);
      ArrayList<LettersInterval> mergedLettersIntervals = MergeIntervals.mergeLettersIntervals(lettersIntervals);
      IntervalsService intervalsService = new IntervalsService(lettersIntervalService);
      intervalsService.saveLettersIntervals(mergedLettersIntervals);
    }
  }
}
