package ru.cft.backend.test.muraviev.backendApplication.intervals;

public class LettersInterval extends Interval<String> implements Comparable<LettersInterval> {
  public LettersInterval(String start, String end) {
    super(start, end);
  }

  public int compareTo(LettersInterval otherInterval) {
    return this.getStart().compareTo(otherInterval.getStart());
  }
}
