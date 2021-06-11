package com.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateMerger {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

        ArrayList<DateRange> dates = new ArrayList<>();

        dates.add(new DateRange("01 Jan 2014", "30 Jan 2014"));
        dates.add(new DateRange("15 Jan 2014", "15 Feb 2014"));
        dates.add(new DateRange("10 Mar 2014", "15 Apr 2014"));
        dates.add(new DateRange("10 Apr 2014", "15 May 2014"));

        System.out.println("Input Given :");
        dates.forEach(dateRange -> System.out.println(dateRange.getStartDate().format(formatter) + " - " + dateRange.getEndDate().format(formatter)));
        System.out.println("---------------------- ");
        dates = mergeDates(dates);

        System.out.println("DateRange output after merge :");
        dates.forEach(interval -> System.out.println(interval.getStartDate().format(formatter) + " - " + interval.getEndDate().format(formatter)));

    }

    public static ArrayList<DateRange> mergeDates(ArrayList<DateRange> dateRangeList) {

        if (dateRangeList.size() == 0 || dateRangeList.size() == 1)
            return dateRangeList;

        Comparator<DateRange> dateRangeComparator = Comparator.comparing(DateRange::getStartDate);
        Collections.sort(dateRangeList, dateRangeComparator); // sort the dates with the first date

        DateRange first = dateRangeList.get(0);
        LocalDate start = first.getStartDate();
        LocalDate end = first.getEndDate();

        ArrayList<DateRange> result = new ArrayList<DateRange>();

        for (int i = 1; i < dateRangeList.size(); i++) {
            DateRange current = dateRangeList.get(i);
            if (end.compareTo(current.getStartDate()) >= 0) { // compare end date with currentStartDate and currentEndDate

                if (end.isBefore(current.getEndDate())) {
                    end = current.getEndDate();
                }

            } else {  // end date is less that current start date
                result.add(new DateRange(start, end));
                start = current.getStartDate();
                end = current.getEndDate();
            }
        }

        result.add(new DateRange(start, end));
        return result;
    }
}



