package com.example.domain.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class OutcomeOdd {

    @Id
    @GeneratedValue
    private int id;

    private BigDecimal oddValue;

    private LocalDateTime validFrom;

    private LocalDateTime validUntil;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Outcome outCome;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Wager> wagers;

    public OutcomeOdd(BigDecimal oddValue, LocalDateTime validFrom, LocalDateTime validUntil, Outcome outCome) {
        this.oddValue = oddValue;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.outCome = outCome;
    }

    public OutcomeOdd() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getOddValue() {
        return oddValue;
    }

    public void setOddValue(BigDecimal oddValue) {
        this.oddValue = oddValue;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public Outcome getOutCome() {
        return outCome;
    }

    public void setOutCome(Outcome outCome) {
        this.outCome = outCome;
    }

    public List<Wager> getWagers() { return wagers; }

    public void setWagers(List<Wager> wagers) { this.wagers = wagers; }

    @Override
    public String toString() {
        return String.format("Actual odd: %.1f, Valid between %s and %s.", getOddValue(), getValidFrom().toString(), getValidUntil().toString());
    }
}
