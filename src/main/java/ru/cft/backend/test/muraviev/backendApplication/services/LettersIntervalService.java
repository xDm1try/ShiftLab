package ru.cft.backend.test.muraviev.backendApplication.services;

import org.springframework.stereotype.Service;
import ru.cft.backend.test.muraviev.backendApplication.entities.LettersIntervalEntity;
import ru.cft.backend.test.muraviev.backendApplication.intervals.DigitsInterval;
import ru.cft.backend.test.muraviev.backendApplication.intervals.LettersInterval;
import ru.cft.backend.test.muraviev.backendApplication.repositories.LettersIntervalRepository;

@Service
public class LettersIntervalService {
  private LettersIntervalRepository lettersIntervalRepository;

  public LettersIntervalService(LettersIntervalRepository lettersIntervalRepository) {
    this.lettersIntervalRepository = lettersIntervalRepository;
  }

  public void save(LettersIntervalEntity lettersIntervalEntity) {
    lettersIntervalRepository.save(lettersIntervalEntity);
  }
  public LettersInterval getMinimalLettersInterval(){
    return lettersIntervalRepository.getMinimalInterval();
  }
}
