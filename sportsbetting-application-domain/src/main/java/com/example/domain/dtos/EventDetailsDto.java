package com.example.domain.dtos;

public class EventDetailsDto {

    private int id;
    private String eventTitle;
    private String eventType;
    private String betType;
    private String outComeValue;
    private String outComeOdd;

    public EventDetailsDto(int id, String eventTitle, String eventType, String betType, String outComeValue, String outComeOdd) {
        this.id = id;
        this.eventTitle = eventTitle;
        this.eventType = eventType;
        this.betType = betType;
        this.outComeValue = outComeValue;
        this.outComeOdd = outComeOdd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }

    public String getOutComeValue() {
        return outComeValue;
    }

    public void setOutComeValue(String outComeValue) {
        this.outComeValue = outComeValue;
    }

    public String getOutComeOdd() {
        return outComeOdd;
    }

    public void setOutComeOdd(String outComeOdd) {
        this.outComeOdd = outComeOdd;
    }
}
