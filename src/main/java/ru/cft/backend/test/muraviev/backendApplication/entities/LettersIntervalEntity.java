package ru.cft.backend.test.muraviev.backendApplication.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "LETTERS_INTERVALS")
public class LettersIntervalEntity {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "START_LETTERS")
  private String start;

  @Column(name = "END_LETTERS")
  private String end;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }
}
