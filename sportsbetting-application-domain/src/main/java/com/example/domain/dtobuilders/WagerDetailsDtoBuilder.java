package com.example.domain.dtobuilders;

import com.example.domain.dtos.WagerDetailsDto;
import com.example.domain.entitybuilders.BuilderBase;

public class WagerDetailsDtoBuilder extends BuilderBase<WagerDetailsDto> {

    private int id;
    private String eventTitle;
    private String eventType;
    private String betType;
    private String outComeValue;
    private String outComeOdd;
    private String wagerAmount;
    private Boolean winner;
    private Boolean processed;

    public WagerDetailsDtoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public WagerDetailsDtoBuilder setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
        return this;
    }

    public WagerDetailsDtoBuilder setEventType(String  eventType) {
        this.eventType = eventType;
        return this;
    }

    public WagerDetailsDtoBuilder setBetType(String betType) {
        this.betType = betType;
        return this;
    }

    public WagerDetailsDtoBuilder setOutComeValue(String outComeValue) {
        this.outComeValue = outComeValue;
        return this;
    }

    public WagerDetailsDtoBuilder setOutComeOdd(String outComeOdd) {
        this.outComeOdd = outComeOdd;
        return this;
    }

    public WagerDetailsDtoBuilder setWagerAmount(String wagerAmount) {
        this.wagerAmount = wagerAmount;
        return this;
    }

    public WagerDetailsDtoBuilder setWinner(Boolean winner) {
        this.winner = winner;
        return this;
    }

    public WagerDetailsDtoBuilder setProcessed(Boolean processed) {
        this.processed = processed;
        return this;
    }

    @Override
    public WagerDetailsDto build() {
        return new WagerDetailsDto(id, eventTitle, eventType, betType, outComeValue, outComeOdd, wagerAmount, winner, processed);
    }
}
