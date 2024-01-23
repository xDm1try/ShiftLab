package ru.cft.backend.test.muraviev.backendApplication.intervals;

public class DigitsInterval extends Interval<Integer> implements Comparable<DigitsInterval> {
  public DigitsInterval(Integer start, Integer end) {
    super(start, end);
  }

  @Override
  public int compareTo(DigitsInterval otherInterval) {
    return this.getStart().compareTo(otherInterval.getStart());
  }
}
