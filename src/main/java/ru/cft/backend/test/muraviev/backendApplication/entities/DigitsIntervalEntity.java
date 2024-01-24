package ru.cft.backend.test.muraviev.backendApplication.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "DIGITS_INTERVALS")
public class DigitsIntervalEntity {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "START_DIGITS")
  private Integer start;
  @Column(name = "END_DIGITS")
  private Integer end;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getStart() {
    return start;
  }

  public void setStart(Integer start) {
    this.start = start;
  }

  public Integer getEnd() {
    return end;
  }

  public void setEnd(Integer end) {
    this.end = end;
  }
}
