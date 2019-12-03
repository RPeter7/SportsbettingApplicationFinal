package com.example.application.services;

import com.example.application.interfaces.SportsBettingService;
import com.example.application.repository.PlayerRepository;
import com.example.application.repository.SportEventRepository;
import com.example.application.repository.WagerRepository;
import com.example.domain.dtobuilders.EventDetailsDtoBuilder;
import com.example.domain.dtobuilders.WagerDetailsDtoBuilder;
import com.example.domain.dtos.EventDetailsDto;
import com.example.domain.dtos.WagerDetailsDto;
import com.example.domain.entities.*;
import com.example.domain.entitybuilders.WagerBuilder;
import com.example.domain.exceptions.OutcomeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class SportsBettingApplicationService implements SportsBettingService {

    private final Logger logger = LoggerFactory.getLogger(SportsBettingApplicationService.class);

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private SportEventRepository sportEventRepository;

    @Autowired
    private WagerRepository wagerRepository;

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player findPlayerByEmail(String email) {
        return playerRepository.findByEmail(email);
    }

    @Override
    public Player findPlayerById(int id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<EventDetailsDto> findAllSportEvents() {
        var sportEvents = new ArrayList<SportEvent>();
        sportEventRepository.findAll().forEach(sportEvents::add);
        return getEventsDetails(sportEvents);
    }

    private List<EventDetailsDto> getEventsDetails(List<SportEvent> sportEvents) {
        int rowNumber = 0;
        var sportEventsDetails = new ArrayList<EventDetailsDto>();
        var sportEventsBetsMap = buildSportEventsBetsMap(sportEvents);

        for (int k = 0; k < sportEventsBetsMap.size(); k++) {
            for (int i = 0; i < sportEventsBetsMap.get(k).size(); i++) {
                for (int j = 0; j < sportEventsBetsMap.get(k).get(i); j++) {
                    sportEventsDetails.add(new EventDetailsDtoBuilder()
                            .setId(++rowNumber)
                            .setEventTitle(String.format("%s - %s", sportEvents.get(k).getTitle(), sportEvents.get(k).getBets().get(i).getOutcomes().get(j).getOutcomeOdds().get(0).getValidUntil().toString()))
                            .setEventType(sportEvents.get(k) instanceof FootballSportEvent ? "Football match" : "Tennis match")
                            .setBetType(sportEvents.get(k).getBets().get(i).getDescription())
                            .setOutComeValue(sportEvents.get(k).getBets().get(i).getOutcomes().get(j).getDescription())
                            .setOutComeOdd(sportEvents.get(k).getBets().get(i).getOutcomes().get(j).getOutcomeOdds().get(0).getOddValue().toString())
                            .build());
                }
            }
        }
        return sportEventsDetails;
    }

    private HashMap<Integer, HashMap<Integer, Integer>> buildSportEventsBetsMap(List<SportEvent> sportEvents) {
        var sportEventBetsMap = new HashMap<Integer, HashMap<Integer, Integer>>();
        var countOfBets = countBets(sportEvents);

        for (int i = 0; i < sportEvents.size(); i++) {
            var betOutcomesMap = new HashMap<Integer, Integer>();

            for (int j = 0; j < countOfBets / sportEvents.size(); j++) {
                betOutcomesMap.put(j, sportEvents.get(i).getBets().get(j).getOutcomes().size());
            }

            sportEventBetsMap.put(i, betOutcomesMap);
        }

        return sportEventBetsMap;
    }

    private int countBets(List<SportEvent> sportEvents) {
        return sportEvents.stream().map(SportEvent::getBets)
                .filter(Objects::nonNull)
                .mapToInt(List::size)
                .sum();
    }

    @Override
    public void saveWager(Wager wager) {
        wagerRepository.save(wager);
    }

    @Override
    public List<WagerDetailsDto> findAllWagers() {
        var wagers = new ArrayList<Wager>();
        wagerRepository.findAll().forEach(wagers::add);
        return getWagerDetails(wagers);
    }

    private List<WagerDetailsDto> getWagerDetails(List<Wager> wagers) {
        var wagersDetails = new ArrayList<WagerDetailsDto>();
        for (var wager : wagers) {
            wagersDetails.add(createWagerDetails(wager));
        }
        return wagersDetails;
    }

    private WagerDetailsDto createWagerDetails(Wager wager) {
        return new WagerDetailsDtoBuilder()
                .setId(wager.getId())
                .setEventTitle(String.format("%s - %s", wager.getOutcomeOdd().getOutCome().getBet().getSportEvent().getTitle(),wager.getOutcomeOdd().getValidUntil() .toString()))
                .setEventType(wager.getOutcomeOdd().getOutCome().getBet().getSportEvent() instanceof FootballSportEvent ? "Football match" : "Tennis match")
                .setBetType(wager.getOutcomeOdd().getOutCome().getBet().getDescription())
                .setOutComeValue(wager.getOutcomeOdd().getOutCome().getDescription())
                .setOutComeOdd(wager.getOutcomeOdd().getOddValue().toString())
                .setWagerAmount(wager.getAmount().toString())
                .setWinner(wager.isWin())
                .setProcessed(wager.isProcessed())
                .build();
    }

    @Override
    public void updatePlayer(Player player) {
        var playerToUpdate = findPlayerById(player.getId());
        playerToUpdate.setAccountNumber(player.getAccountNumber());
        playerToUpdate.setBalance(player.getBalance());
        playerToUpdate.setName(player.getName());
        savePlayer(playerToUpdate);
    }

    @Override
    public void addChosenOutComeToPlayer(int chosen, double wagerAmount, int playerId) {
        int count = 0;
        var sportEvents = new ArrayList<SportEvent>();
        sportEventRepository.findAll().forEach(sportEvents::add);
        var playerToUpdate = playerRepository.findById(playerId);

        for (var sportEvent: sportEvents) {
            for (var bet: sportEvent.getBets()) {
                for (var outcome: bet.getOutcomes()) {
                    if (chosen - 1 == count) {
                        playerToUpdate.setBalance(playerToUpdate.getBalance().subtract(BigDecimal.valueOf(wagerAmount)));
                        savePlayer(playerToUpdate);
                        var wager = createWager(BigDecimal.valueOf(wagerAmount), outcome.getOutcomeOdds().get(0), playerToUpdate);
                        calculateResults(wager, playerId);
                        saveWager(wager);
                        return;
                    }
                    count++;
                }
            }
        }

        throw new OutcomeNotFoundException("This Outcome not found!");
    }

    private Wager createWager(BigDecimal wageAmount, OutcomeOdd selectedOutcomeOdd, Player player) {
        return new WagerBuilder()
                .setAmount(wageAmount)
                .setOutcomeOdd(selectedOutcomeOdd)
                .setPlayer(player)
                .build();
    }

    private void calculateResults(Wager wager, int playerId) {
        if (wager.getOutcomeOdd().getValidUntil().isBefore(LocalDateTime.now())) {
            wager.setWin(new Random().nextBoolean());
            wager.setProcessed(true);
            if (wager.isWin()) {
                addToPlayersBalance(wager, playerId);
            }
        }
    }

    private void addToPlayersBalance(Wager wager, int playerId) {
        var playerToUpdate = findPlayerById(playerId);
        playerToUpdate.setBalance(findPlayerById(playerId).getBalance().add(calculateWinAmount(wager)));
        savePlayer(playerToUpdate);
    }

    private BigDecimal calculateWinAmount(Wager wager) {
        return wager.getAmount().multiply(wager.getOutcomeOdd().getOddValue());
    }

    @Override
    public void deleteWagerById(int id) {
        wagerRepository.deleteById(id);
    }
}
