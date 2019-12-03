package com.example.domain.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Outcome {

    @Id
    @GeneratedValue
    private int id;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Bet bet;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<OutcomeOdd> outcomeOdds;

    public Outcome(String description, Bet bet, List<OutcomeOdd> outcomeOdds) {
        this.description = description;
        this.bet = bet;
        this.outcomeOdds = outcomeOdds;
    }

    public Outcome() { }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public List<OutcomeOdd> getOutcomeOdds() {
        return outcomeOdds;
    }

    public void setOutcomeOdds(List<OutcomeOdd> outcomeOdds) {
        this.outcomeOdds = outcomeOdds;
    }

    @Override
    public String toString() {
        return String.format("Outcome: %s, ", getDescription());
    }
}
