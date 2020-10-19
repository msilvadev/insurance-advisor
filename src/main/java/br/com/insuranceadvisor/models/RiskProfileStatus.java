package br.com.insuranceadvisor.models;

import java.util.HashMap;
import java.util.Map;

public enum RiskProfileStatus {
    ECONOMIC("economic"),
    REGULAR("regular"),
    RESPONSIBLE("responsible"),
    INELIGIBLE("ineligible");

    private static final Map<String, RiskProfileStatus> typeMap;

    static {
        typeMap = new HashMap<String, RiskProfileStatus>();
        for (RiskProfileStatus type : values()) {
            typeMap.put(type.value, type);
        }
    }

    private final String value;

    RiskProfileStatus(String value) {
        this.value = value;
    }

    public static RiskProfileStatus findByValue(String value) {
        return typeMap.get(value);
    }

    public String getValue() {
        return value;
    }
}
