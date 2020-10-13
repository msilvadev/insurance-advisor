package br.com.insuranceadvisor.model;

import java.util.HashMap;
import java.util.Map;

public enum MaritalStatus {
    SINGLE("single"),
    MARRIED("married");

    private static final Map<String, MaritalStatus> typeMap;

    static {
        typeMap = new HashMap<String, MaritalStatus>();
        for (MaritalStatus type : values()) {
            typeMap.put(type.value, type);
        }
    }

    private final String value;

    MaritalStatus(String value) {
        this.value = value;
    }

    public static MaritalStatus findByValue(String value) {
        return typeMap.get(value);
    }

    public String getValue() {
        return value;
    }
}
