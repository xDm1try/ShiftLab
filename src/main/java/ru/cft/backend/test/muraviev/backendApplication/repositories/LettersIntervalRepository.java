package ru.cft.backend.test.muraviev.backendApplication.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.cft.backend.test.muraviev.backendApplication.entities.LettersIntervalEntity;
import ru.cft.backend.test.muraviev.backendApplication.intervals.LettersInterval;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LettersIntervalRepository implements IntervalRepository {
  private JdbcTemplate jdbcTemplate;
  private AtomicLong atomicLong = new AtomicLong(0);

  public LettersIntervalRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void save(LettersIntervalEntity newInterval) {
    jdbcTemplate.update(
        "insert into LETTERS_INTERVALS (ID, START_LETTERS, END_LETTERS) values (?, ?, ?)",
        atomicLong.getAndIncrement(),
        newInterval.getStart(),
        newInterval.getEnd());
  }

  @Override
  public LettersInterval getMinimalInterval() {
    return (LettersInterval) jdbcTemplate.query(
        "select START_LETTERS, END_LETTERS from LETTERS_INTERVALS",
        this::mapRowToIntervals);
  }

  private LettersInterval mapRowToIntervals(ResultSet resultSet, int i) throws SQLException {
    return new LettersInterval(resultSet.getString("START_LETTERS"),
        resultSet.getString("END_LETTERS"));
  }
}
