package br.com.insuranceadvisor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HouseStatus {
    @JsonProperty("ownership_status")
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
