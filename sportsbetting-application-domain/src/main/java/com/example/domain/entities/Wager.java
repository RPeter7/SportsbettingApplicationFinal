package com.example.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Wager {

    @Id
    @GeneratedValue
    private int id;

    private BigDecimal amount;

    private LocalDateTime timestampCreated;

    private boolean processed;

    private boolean win;

    @ManyToOne(fetch = FetchType.EAGER)
    private OutcomeOdd outcomeOdd;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @ManyToOne(fetch = FetchType.EAGER)
    private Player player;

    public Wager(BigDecimal amount, LocalDateTime timestampCreated, boolean processed, boolean win, OutcomeOdd outcomeOdd, Currency currency, Player player) {
        this.amount = amount;
        this.timestampCreated = timestampCreated;
        this.processed = processed;
        this.win = win;
        this.outcomeOdd = outcomeOdd;
        this.currency = currency;
        this.player = player;
    }

    public Wager() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(LocalDateTime timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public OutcomeOdd getOutcomeOdd() {
        return outcomeOdd;
    }

    public void setOutcomeOdd(OutcomeOdd outcomeOdd) {
        this.outcomeOdd = outcomeOdd;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return String.format("Wager '%s=%s' of %s [odd: %.1f, amount: %.1f], win: %b",
                getOutcomeOdd().getOutCome().getBet().getDescription(),
                getOutcomeOdd().getOutCome().getDescription(),
                getOutcomeOdd().getOutCome().getBet().getSportEvent().getTitle(),
                getOutcomeOdd().getOddValue(),
                getAmount(),
                isWin());
    }
}
