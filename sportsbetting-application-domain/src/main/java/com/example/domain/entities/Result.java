package com.example.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Result {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Outcome> outcomes;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }
}
