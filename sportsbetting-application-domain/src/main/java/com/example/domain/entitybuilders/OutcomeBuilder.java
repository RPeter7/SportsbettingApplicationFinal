package com.example.domain.entitybuilders;

import com.example.domain.entities.Bet;
import com.example.domain.entities.Outcome;
import com.example.domain.entities.OutcomeOdd;

import java.util.ArrayList;
import java.util.List;

public class OutcomeBuilder extends BuilderBase<Outcome> {

    private String description;
    private Bet bet;
    private List<OutcomeOdd> outcomeOdds;

    public OutcomeBuilder() {
        outcomeOdds = new ArrayList<>();
    }

    public OutcomeBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public OutcomeBuilder setBet(Bet bet) {
        this.bet = bet;
        return this;
    }

    public OutcomeBuilder addOutcomeOdd(OutcomeOdd outComeodd) {
        this.outcomeOdds.add(outComeodd);
        return this;
    }

    @Override
    public Outcome build() {
        return new Outcome(description, bet, outcomeOdds);
    }
}
