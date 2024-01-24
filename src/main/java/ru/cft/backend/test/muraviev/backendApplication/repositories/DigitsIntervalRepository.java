package ru.cft.backend.test.muraviev.backendApplication.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.cft.backend.test.muraviev.backendApplication.entities.DigitsIntervalEntity;
import ru.cft.backend.test.muraviev.backendApplication.intervals.DigitsInterval;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class DigitsIntervalRepository {
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


  public List<DigitsInterval> getMinimalInterval() {
    List<DigitsInterval> intervalsList = jdbcTemplate.query(
        "select START_DIGITS, END_DIGITS from DIGITS_INTERVALS\n" +
            "ORDER BY START_DIGITS ASC, END_DIGITS ASC\n" +
            "LIMIT 1",
        this::mapRowToIntervals);
    return intervalsList;
  }

  private DigitsInterval mapRowToIntervals(ResultSet resultSet, int i) throws SQLException {
    return new DigitsInterval(resultSet.getInt("START_DIGITS"),
        resultSet.getInt("END_DIGITS"));
  }

}
