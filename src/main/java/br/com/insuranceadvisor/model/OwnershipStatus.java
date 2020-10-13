package br.com.insuranceadvisor.model;

import java.util.HashMap;
import java.util.Map;

public enum OwnershipStatus {
    OWNED("owned"),
    MORTGAGED("mortgaged");

    private static final Map<String, OwnershipStatus> typeMap;

    static {
        typeMap = new HashMap<String, OwnershipStatus>();
        for (OwnershipStatus type : values()) {
            typeMap.put(type.value, type);
        }
    }

    private final String value;

    OwnershipStatus(String value) {
        this.value = value;
    }

    public static OwnershipStatus findByValue(String value) {
        return typeMap.get(value);
    }

    public String getValue() {
        return value;
    }
}
