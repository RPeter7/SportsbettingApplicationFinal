package com.example.domain.entitybuilders;

import com.example.domain.entities.Bet;
import com.example.domain.entities.BetType;
import com.example.domain.entities.Outcome;
import com.example.domain.entities.SportEvent;

import java.util.ArrayList;
import java.util.List;

public class BetBuilder extends BuilderBase<Bet> {

    private String description;
    private SportEvent sportEvent;
    private BetType betType;
    private List<Outcome> outcomes;

    public BetBuilder() {
        outcomes = new ArrayList<>();
    }

    public BetBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public BetBuilder setSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
        return this;
    }

    public BetBuilder setBetType(BetType betType) {
        this.betType = betType;
        return this;
    }

    public BetBuilder addOutCome(Outcome outCome) {
        this.outcomes.add(outCome);
        return this;
    }

    @Override
    public Bet build() {
        return new Bet(description, sportEvent, betType, outcomes);
    }
}
