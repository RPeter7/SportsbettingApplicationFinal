package com.example.domain.entitybuilders;

import com.example.domain.entities.Outcome;
import com.example.domain.entities.OutcomeOdd;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutcomeOddBuilder extends BuilderBase<OutcomeOdd> {

    private BigDecimal oddValue;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private Outcome outCome;

    public OutcomeOddBuilder setOddValue(BigDecimal oddValue) {
        this.oddValue = oddValue;
        return this;
    }

    public OutcomeOddBuilder setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public OutcomeOddBuilder setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
        return this;
    }

    public OutcomeOddBuilder setOutcome(Outcome outCome) {
        this.outCome = outCome;
        return this;
    }

    @Override
    public OutcomeOdd build() {
        return new OutcomeOdd(oddValue, validFrom, validUntil, outCome);
    }
}
