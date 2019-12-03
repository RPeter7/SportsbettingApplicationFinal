package com.example.domain.entities;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class FootballSportEvent extends SportEvent {
    public FootballSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, List<Bet> bets, Result result) {
        super(title, startDate, endDate, bets, result);
    }

    public FootballSportEvent() { }
}
