package br.com.insuranceadvisor.model;

import br.com.insuranceadvisor.model.validator.EnumNamePattern;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HouseStatus {
    @JsonProperty("ownership_status")
    @EnumNamePattern(regexp = "OWNED|MORTGAGED")
    private OwnershipStatus ownershipStatus;

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
