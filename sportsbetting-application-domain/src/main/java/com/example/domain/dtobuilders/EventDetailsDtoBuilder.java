package com.example.domain.dtobuilders;

import com.example.domain.dtos.EventDetailsDto;
import com.example.domain.entitybuilders.BuilderBase;

public class EventDetailsDtoBuilder extends BuilderBase<EventDetailsDto> {

    private int id;
    private String eventTitle;
    private String eventType;
    private String betType;
    private String outComeValue;
    private String outComeOdd;

    public EventDetailsDtoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public EventDetailsDtoBuilder setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
        return this;
    }

    public EventDetailsDtoBuilder setEventType(String  eventType) {
        this.eventType = eventType;
        return this;
    }

    public EventDetailsDtoBuilder setBetType(String betType) {
        this.betType = betType;
        return this;
    }

    public EventDetailsDtoBuilder setOutComeValue(String outComeValue) {
        this.outComeValue = outComeValue;
        return this;
    }

    public EventDetailsDtoBuilder setOutComeOdd(String outComeOdd) {
        this.outComeOdd = outComeOdd;
        return this;
    }

    @Override
    public EventDetailsDto build() {
        return new EventDetailsDto(id, eventTitle, eventType, betType, outComeValue, outComeOdd);
    }
}
