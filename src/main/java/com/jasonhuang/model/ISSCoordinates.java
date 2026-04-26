package com.jasonhuang.model;

public class ISSCoordinates {
    public ISSPosition iss_position;
    public String message;
    public int timestamp;

    public ISSPosition getIss_position() {
        return iss_position;
    }

    public String getMessage() {
        return message;
    }

    public int getTimestamp() {
        return timestamp;
    }
}