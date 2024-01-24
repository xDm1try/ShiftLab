package ru.cft.backend.test.muraviev.backendApplication.controllers;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import ru.cft.backend.test.muraviev.backendApplication.intervals.DigitsInterval;
import ru.cft.backend.test.muraviev.backendApplication.intervals.LettersInterval;

import java.util.ArrayList;

public class JsonParser {

  public static ArrayList<DigitsInterval> jsonToDigitsIntervals(String rowData) throws ParseException {
    JSONArray arrayOfIntervals = new JSONArray(rowData);
    ArrayList<DigitsInterval> digitsIntervals = new ArrayList<>();
    for (int i = 0; i < arrayOfIntervals.length(); i++) {
      JSONArray interval = arrayOfIntervals.getJSONArray(i);
      Integer start = interval.getInt(0);
      Integer end = interval.getInt(1);
      digitsIntervals.add(new DigitsInterval(start, end));
    }
    return digitsIntervals;
  }

  public static ArrayList<LettersInterval> jsonToLetterIntervals(String rowData) throws ParseException {
    JSONArray arrayOfIntervals = new JSONArray(rowData);
    ArrayList<LettersInterval> lettersIntervals = new ArrayList<>();
    for (int i = 0; i < arrayOfIntervals.length(); i++) {
      JSONArray interval = arrayOfIntervals.getJSONArray(i);
      String start = interval.getString(0);
      String end = interval.getString(1);
      lettersIntervals.add(new LettersInterval(start, end));
    }
    return lettersIntervals;
  }
}
