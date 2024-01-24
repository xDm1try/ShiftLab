package ru.cft.backend.test.muraviev.backendApplication.services;

import ru.cft.backend.test.muraviev.backendApplication.intervals.DigitsInterval;
import ru.cft.backend.test.muraviev.backendApplication.intervals.Interval;
import ru.cft.backend.test.muraviev.backendApplication.intervals.LettersInterval;

import java.util.ArrayList;

public class MergeIntervals {
  public static ArrayList<DigitsInterval> mergeDigitsIntervals(ArrayList<DigitsInterval> inputIntervals){
    ArrayList<DigitsInterval> mergedIntervals = new ArrayList<>();
    inputIntervals.sort(DigitsInterval::compareTo);
    DigitsInterval currentInterval = inputIntervals.get(0);
    inputIntervals.remove(0);
    for(DigitsInterval interval : inputIntervals){
      if(currentInterval.getEnd() < interval.getStart()){
        mergedIntervals.add(currentInterval);
        currentInterval = interval;
      }else{
        currentInterval = new DigitsInterval(currentInterval.getStart(),
            Math.max(currentInterval.getEnd(), interval.getEnd()));
      }
    }
    mergedIntervals.add(currentInterval);
    return mergedIntervals;
  }

  public static ArrayList<LettersInterval> mergeLettersIntervals(ArrayList<LettersInterval> inputIntervals){
    ArrayList<LettersInterval> mergedIntervals = new ArrayList<>();
    inputIntervals.sort(LettersInterval::compareTo);
    LettersInterval currentInterval = inputIntervals.get(0);
    inputIntervals.remove(0);
    for(LettersInterval interval : inputIntervals){
      if(currentInterval.getEnd().compareTo(interval.getStart()) < 0){
        mergedIntervals.add(currentInterval);
        currentInterval = interval;
      }else{
        String maxEnd = currentInterval.getEnd().compareTo(interval.getEnd()) < 0 ? interval.getEnd() : currentInterval.getEnd();
        currentInterval = new LettersInterval(currentInterval.getStart(), maxEnd);
      }
    }
    mergedIntervals.add(currentInterval);
    return mergedIntervals;
  }

}
