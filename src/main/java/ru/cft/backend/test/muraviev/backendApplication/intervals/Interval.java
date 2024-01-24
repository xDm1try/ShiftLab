package ru.cft.backend.test.muraviev.backendApplication.intervals;

public abstract class Interval<T> {
  private T start;
  private T end;

  public Interval(T start, T end) {
    this.start = start;
    this.end = end;
  }

  public T getStart() {
    return this.start;
  }

  public T getEnd() {
    return this.end;
  }

  public String toString() {
    return "[" + this.start + "," + this.end + "]";
  }


}
