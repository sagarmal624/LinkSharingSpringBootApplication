package com.sagarandcompany.linkSharing.utility;

public enum Seriousness {
    SERIOUS("Serious"),
    VERYSERIOUS("Very Serious"),
    CASUAL("Casual");

    Seriousness(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public Seriousness getValue(String name) {
        return Seriousness.valueOf(name);
    }


}
