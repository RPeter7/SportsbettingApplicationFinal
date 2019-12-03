package com.example.domain.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Player extends User {

    private String name;

    private String accountNumber;

    private BigDecimal balance;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE )
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Wager> wagers;

    public Player(String email, String password, String name, String accountNumber, BigDecimal balance, LocalDate dateOfBirth, Currency currency) {
        super(email, password);
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateOfBirth = dateOfBirth;
        this.currency = currency;
    }

    public Player() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<Wager> getWagers() { return wagers; }

    public void setWagers(List<Wager> wagers) { this.wagers = wagers; }
}
