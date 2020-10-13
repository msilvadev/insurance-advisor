package br.com.insuranceadvisor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Analysis {
    @PositiveOrZero(message = "${age.positive}")
    private int age;

    @PositiveOrZero(message = "${dependents.positive}")
    private int dependents;

    private HouseStatus house;

    @Min(value = 0, message = "Age should not be less than 0")
    private int income;

    private MaritalStatus maritalStatus;

    @Size(min = 3, max = 3, message = "${risk.questions}")
    private int[] risk_questions;

    private Vehicle vehicle;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDependents() {
        return dependents;
    }

    public void setDependents(int dependents) {
        this.dependents = dependents;
    }

    public HouseStatus getHouse() {
        return house;
    }

    public void setHouse(HouseStatus house) {
        this.house = house;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int[] getRisk_questions() {
        return risk_questions;
    }

    public void setRisk_questions(int[] risk_questions) {
        this.risk_questions = risk_questions;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Analysis{" +
                "age=" + age +
                ", dependents=" + dependents +
                ", house=" + house +
                ", income=" + income +
                ", maritalStatus=" + maritalStatus +
                ", risk_questions=" + Arrays.toString(risk_questions) +
                ", vehicle=" + vehicle +
                '}';
    }
}
