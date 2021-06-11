package com.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class DateRange {
    private LocalDate startDate;
    private LocalDate endDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

    DateRange(String start, String end) {
        startDate = LocalDate.parse(start, formatter);
        endDate = LocalDate.parse(end, formatter);
    }

    DateRange(LocalDate start, LocalDate end) {
        startDate = start;
        endDate = end;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

