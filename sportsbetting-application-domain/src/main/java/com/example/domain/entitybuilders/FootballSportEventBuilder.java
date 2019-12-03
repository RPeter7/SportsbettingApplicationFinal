package com.example.domain.entitybuilders;


import com.example.domain.entities.Bet;
import com.example.domain.entities.FootballSportEvent;
import com.example.domain.entities.Result;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FootballSportEventBuilder extends BuilderBase<FootballSportEvent> {

    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Bet> bets;
    private Result result;

    public FootballSportEventBuilder() {
        bets = new ArrayList<>();
    }

    public FootballSportEventBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public FootballSportEventBuilder setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public FootballSportEventBuilder setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public FootballSportEventBuilder addBet(Bet bet) {
        this.bets.add(bet);
        return this;
    }

    public FootballSportEventBuilder setResult(Result result) {
        this.result = result;
        return this;
    }

    @Override
    public FootballSportEvent build() {
        return new FootballSportEvent(title, startDate, endDate, bets, result);
    }
}
