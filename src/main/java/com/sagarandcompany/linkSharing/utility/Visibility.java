package com.sagarandcompany.linkSharing.utility;

public enum Visibility {
    PUBLIC("Public"),
    PRIVATE("Private");

    Visibility(String value) {
        this.value = value;
    }

    private String value;

    public Visibility getValue(String name) {
        return Visibility.valueOf(name);
    }
}
