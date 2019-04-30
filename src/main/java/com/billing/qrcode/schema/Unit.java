package com.billing.qrcode.schema;

public enum Unit {

    PC(1),
    DZ(2);

    private final int value;

    Unit(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

    public static Unit fromValue(String value) {
        try {
            return valueOf(value);
        } catch (Exception ex) {
            return Unit.DZ;
        }
    }
}
