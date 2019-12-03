package com.example.application.utilities;

import com.example.domain.entities.SportEvent;
import com.example.domain.entitybuilders.BetBuilder;
import com.example.domain.entitybuilders.FootballSportEventBuilder;
import com.example.domain.entitybuilders.OutcomeBuilder;
import com.example.domain.entitybuilders.OutcomeOddBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

@Service
public class SportEventFactory {

    public SportEvent get() {

        var outComeOddOne = new OutcomeOddBuilder()
                .setOddValue(BigDecimal.valueOf(2))
                .setValidFrom(LocalDateTime.of(2019, Month.DECEMBER, 1, 17, 0,0))
                .setValidUntil(LocalDateTime.of(2019, Month.DECEMBER, 1, 19, 0,0))
                .build();

        var outComeOddTwo = new OutcomeOddBuilder()
                .setOddValue(BigDecimal.valueOf(3))
                .setValidFrom(LocalDateTime.of(2020, Month.JANUARY, 28, 12, 0,0))
                .setValidUntil(LocalDateTime.of(2020, Month.JANUARY, 28, 14, 0,0))
                .build();

        var outComeOddThree = new OutcomeOddBuilder()
                .setOddValue(BigDecimal.valueOf(2))
                .setValidFrom(LocalDateTime.of(2020, Month.JANUARY, 5, 12, 0,0))
                .setValidUntil(LocalDateTime.of(2020, Month.JANUARY, 5, 14, 0,0))
                .build();

        var outComeOddFour = new OutcomeOddBuilder()
                .setOddValue(BigDecimal.valueOf(3))
                .setValidFrom(LocalDateTime.of(2019, Month.DECEMBER, 2, 14, 0,0))
                .setValidUntil(LocalDateTime.of(2019, Month.DECEMBER, 2, 16, 0,0))
                .build();

        var sportEvent =  new FootballSportEventBuilder()
                .setTitle("Arsenal - Chelsea")
                .setStartDate(LocalDateTime.of(2020, Month.JANUARY, 1, 12, 0,0))
                .build();

        var betOne = new BetBuilder().setDescription("Goals")
                .setSportEvent(sportEvent)
                .build();

        var betTwo = new BetBuilder().setDescription("Goals")
                .setSportEvent(sportEvent)
                .build();

        var betThree = new BetBuilder().setDescription("Winner")
                .setSportEvent(sportEvent)
                .build();

        var outComeOne = new OutcomeBuilder().setDescription("1")
                .addOutcomeOdd(outComeOddOne)
                .setBet(betOne)
                .build();

        var outComeTwo = new OutcomeBuilder().setDescription("3")
                .addOutcomeOdd(outComeOddTwo)
                .setBet(betTwo)
                .build();

        var outComeThree = new OutcomeBuilder().setDescription("Arsenal")
                .addOutcomeOdd(outComeOddThree)
                .setBet(betThree)
                .build();

        var outComeFour = new OutcomeBuilder().setDescription("Chelsea")
                .addOutcomeOdd(outComeOddFour)
                .setBet(betThree)
                .build();

        outComeOddOne.setOutCome(outComeOne);
        outComeOddTwo.setOutCome(outComeTwo);
        outComeOddThree.setOutCome(outComeThree);
        outComeOddFour.setOutCome(outComeFour);

        betOne.getOutcomes().add(outComeOne);
        betTwo.getOutcomes().add(outComeTwo);
        betThree.getOutcomes().add(outComeThree);
        betThree.getOutcomes().add(outComeFour);

        sportEvent.getBets().add(betOne);
        sportEvent.getBets().add(betTwo);
        sportEvent.getBets().add(betThree);

        return sportEvent;
    }
}
