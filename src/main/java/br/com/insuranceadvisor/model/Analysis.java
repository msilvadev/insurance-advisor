package br.com.insuranceadvisor.model;

import br.com.insuranceadvisor.model.validator.EnumNamePattern;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Analysis {

    @PositiveOrZero(message = "{age.positive}")
    private int age;

    @PositiveOrZero(message = "{dependents.positive}")
    private int dependents;

    private HouseStatus house;

    @PositiveOrZero(message = "{income.positive}")
    private int income;

    @JsonProperty("marital_status")
    @EnumNamePattern(regexp = "SINGLE|MARRIED")
    private MaritalStatus maritalStatus;

    @JsonProperty("risk_questions")
    @Size(min = 3, max = 3, message = "{risk.questions}")
    private int[] riskQuestions;

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

    public int[] getRiskQuestions() {
        return riskQuestions;
    }

    public void setRiskQuestions(int[] riskQuestions) {
        this.riskQuestions = riskQuestions;
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
                ", marital_status=" + maritalStatus +
                ", risk_questions=" + Arrays.toString(riskQuestions) +
                ", vehicle=" + vehicle +
                '}';
    }
}
