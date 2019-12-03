package com.example.domain.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SportEvent {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Bet> bets;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Result result;

    public SportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, List<Bet> bets, Result result) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bets = bets;
        this.result = result;
    }

    public SportEvent() { }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
         return String.format("Sport event: %s (start: %s)", getTitle(), getStartDate().toString());
    }
}
