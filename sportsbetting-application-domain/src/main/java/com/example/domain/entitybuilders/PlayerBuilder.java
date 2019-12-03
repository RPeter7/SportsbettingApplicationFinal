package com.example.domain.entitybuilders;

import com.example.domain.entities.Currency;
import com.example.domain.entities.Player;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PlayerBuilder extends BuilderBase<Player> {

    private String email;
    private String password;
    private String name;
    private String accountNumber;
    private BigDecimal balance;
    private LocalDate dateOfBirth;
    private Currency currency;

    public PlayerBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public PlayerBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public PlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public PlayerBuilder setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public PlayerBuilder setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public PlayerBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public Player build() {
        return new Player(email, password, name, accountNumber, balance, dateOfBirth, currency);
    }
}
