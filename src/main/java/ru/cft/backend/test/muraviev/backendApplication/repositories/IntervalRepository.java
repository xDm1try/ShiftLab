package ru.cft.backend.test.muraviev.backendApplication.repositories;

import ru.cft.backend.test.muraviev.backendApplication.intervals.Interval;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public interface IntervalRepository {
  Interval getMinimalInterval();
}
