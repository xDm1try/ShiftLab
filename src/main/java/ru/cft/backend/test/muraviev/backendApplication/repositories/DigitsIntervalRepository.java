package ru.cft.backend.test.muraviev.backendApplication.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.cft.backend.test.muraviev.backendApplication.entities.DigitsIntervalEntity;
import ru.cft.backend.test.muraviev.backendApplication.intervals.DigitsInterval;
import ru.cft.backend.test.muraviev.backendApplication.intervals.Interval;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class DigitsIntervalRepository implements IntervalRepository {
  private JdbcTemplate jdbcTemplate;
  private AtomicLong atomicLong = new AtomicLong(0);

  public DigitsIntervalRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void save(DigitsIntervalEntity newInterval) {
    jdbcTemplate.update(
        "insert into DIGITS_INTERVALS (ID, START_DIGITS, END_DIGITS) values (?, ?, ?)",
        atomicLong.getAndIncrement(),
        newInterval.getStart(),
        newInterval.getEnd());
  }

  @Override
  public DigitsInterval getMinimalInterval() {
    return (DigitsInterval) jdbcTemplate.query(
        "select START_DIGITS, END_DIGITS from DIGITS_INTERVALS",
        this::mapRowToIntervals);
  }

  private DigitsInterval mapRowToIntervals(ResultSet resultSet, int i) throws SQLException {
    return new DigitsInterval(resultSet.getInt("START_DIGITS"),
        resultSet.getInt("END_DIGITS"));
  }

}
