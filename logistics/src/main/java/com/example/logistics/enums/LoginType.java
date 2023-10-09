package com.example.logistics.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LoginType {
        EMAIL, PHONE, APPLE, GOOGLE, FACEBOOK;

        @JsonCreator
        public static LoginType fromString(String value) {
                return valueOf(value.toUpperCase());
        }

        @JsonValue
        public String toStringValue() {
                return this.name().toLowerCase();
        }
}
