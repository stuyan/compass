package ru.stuyan.compass.logic;

public class Range {

    private final static Double MAX_DEGREE = 360d;

    private Double from;

    private Double to;

    public Range(String rangeStr) {
        String[] range = rangeStr.split("-");
        this.from = Double.valueOf(range[0]);
        this.to = Double.valueOf(range[1]);
    }

    public Range(Double from, Double to) {
        this.from = from;
        this.to = to;
    }

    public boolean in(Double value) {
        return testFrom(value) && testTo(value);
    }

    private boolean testFrom(Double value) {
        double from = (this.from > to && this.to >= value) ? 0 : this.from;
        return from <= value;
    }

    private boolean testTo(Double value) {
        double to = (from > this.to && this.from <= value) ? MAX_DEGREE : this.to;
        return to >= value;
    }

}
