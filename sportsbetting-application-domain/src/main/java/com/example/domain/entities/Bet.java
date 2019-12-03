package com.example.domain.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bet {

    @Id
    @GeneratedValue
    private int id;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private SportEvent sportEvent;

    @Enumerated(EnumType.STRING)
    private BetType betType;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Outcome> outcomes;

    public Bet(String description, SportEvent sportEvent, BetType betType, List<Outcome> outcomes) {
        this.description = description;
        this.sportEvent = sportEvent;
        this.betType = betType;
        this.outcomes = outcomes;
    }

    public Bet() { }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SportEvent getSportEvent() {
        return sportEvent;
    }

    public void setSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }

    public BetType getBetType() {
        return betType;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    @Override
    public String toString() {
        return String.format(" Bet: %s, ", getDescription());
    }
}
