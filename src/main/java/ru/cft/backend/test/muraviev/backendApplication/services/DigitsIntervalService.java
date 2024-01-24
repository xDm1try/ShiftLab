package ru.cft.backend.test.muraviev.backendApplication.services;

import org.springframework.stereotype.Service;
import ru.cft.backend.test.muraviev.backendApplication.entities.DigitsIntervalEntity;
import ru.cft.backend.test.muraviev.backendApplication.intervals.DigitsInterval;
import ru.cft.backend.test.muraviev.backendApplication.repositories.DigitsIntervalRepository;

@Service
public class DigitsIntervalService {
  private DigitsIntervalRepository digitsIntervalRepository;

  public DigitsIntervalService(DigitsIntervalRepository digitsIntervalRepository) {
    this.digitsIntervalRepository = digitsIntervalRepository;
  }

  public void save(DigitsIntervalEntity digitsIntervalEntity) {
    digitsIntervalRepository.save(digitsIntervalEntity);
  }
  public DigitsInterval getMinimalDigitsInterval(){
    return digitsIntervalRepository.getMinimalInterval();
  }
}
