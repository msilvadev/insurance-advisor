package br.com.insuranceadvisor.models;

import br.com.insuranceadvisor.models.validator.EnumNamePattern;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HouseStatus {
    @JsonProperty("ownership_status")
    @EnumNamePattern(regexp = "OWNED|MORTGAGED")
    private OwnershipStatus ownershipStatus;

    public HouseStatus() { }

    public HouseStatus(@EnumNamePattern(regexp = "OWNED|MORTGAGED") OwnershipStatus ownershipStatus) {
        this.ownershipStatus = ownershipStatus;
    }

    public OwnershipStatus getOwnershipStatus() {
        return ownershipStatus;
    }

    public void setOwnershipStatus(OwnershipStatus ownershipStatus) {
        this.ownershipStatus = ownershipStatus;
    }

    @Override
    public String toString() {
        return "HouseStatus{" +
                "ownershipStatus=" + ownershipStatus +
                '}';
    }
}
