package br.com.insuranceadvisor.models;

public class Vehicle {
    private int year;

    public Vehicle() { }

    public Vehicle(int year) {
        this.year = year;
    }

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
