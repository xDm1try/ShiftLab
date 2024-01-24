package ru.cft.backend.test.muraviev.backendApplication.services;

import ru.cft.backend.test.muraviev.backendApplication.entities.DigitsIntervalEntity;
import ru.cft.backend.test.muraviev.backendApplication.entities.LettersIntervalEntity;
import ru.cft.backend.test.muraviev.backendApplication.intervals.DigitsInterval;
import ru.cft.backend.test.muraviev.backendApplication.intervals.LettersInterval;
import ru.cft.backend.test.muraviev.backendApplication.repositories.DigitsIntervalRepository;
import ru.cft.backend.test.muraviev.backendApplication.repositories.LettersIntervalRepository;


public class IntervalsService {
  private DigitsIntervalService digitsIntervalService;
  private LettersIntervalService lettersIntervalService;

  public IntervalsService(DigitsIntervalService digitsIntervalService,
                          LettersIntervalService lettersIntervalService) {
    this.digitsIntervalService = digitsIntervalService;
    this.lettersIntervalService = lettersIntervalService;
  }

  public IntervalsService(DigitsIntervalService digitsIntervalService) {
    this.digitsIntervalService = digitsIntervalService;
  }

  public IntervalsService(LettersIntervalService lettersIntervalService) {
    this.lettersIntervalService = lettersIntervalService;
  }

  public void saveDigitsIntervals(Iterable<DigitsInterval> intervals) {
    for (DigitsInterval interval : intervals) {
      DigitsIntervalEntity entity = new DigitsIntervalEntity();
      entity.setStart(interval.getStart());
      entity.setEnd(interval.getEnd());
      digitsIntervalService.save(entity);
    }
  }

  public void saveLettersIntervals(Iterable<LettersInterval> intervals) {
    for (LettersInterval interval : intervals) {
      LettersIntervalEntity entity = new LettersIntervalEntity();
      entity.setStart(interval.getStart());
      entity.setEnd(interval.getEnd());
      lettersIntervalService.save(entity);
    }
  }

  public DigitsInterval getMinimalDigitsInterval() {
    return digitsIntervalService.getMinimalDigitsInterval();
  }

  public LettersInterval getMinimalLettersInterval() {
    return lettersIntervalService.getMinimalLettersInterval();
  }
}
