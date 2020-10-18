package br.com.insuranceadvisor.model;

public class Vehicle {
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "year=" + year +
                '}';
    }
}
