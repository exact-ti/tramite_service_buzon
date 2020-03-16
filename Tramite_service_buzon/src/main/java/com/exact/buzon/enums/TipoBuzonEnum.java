package com.exact.buzon.enums;

public enum TipoBuzonEnum {
	PERSONAL(1),
	GENERICO(2);	
	
	private final int value;
	
    private TipoBuzonEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
