package com.example.application.interfaces;


import com.example.domain.dtos.EventDetailsDto;
import com.example.domain.dtos.WagerDetailsDto;
import com.example.domain.entities.Player;
import com.example.domain.entities.Wager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportsBettingService {
    void savePlayer(Player player);
    Player findPlayerByEmail(String email);
    Player findPlayerById(int id);
    List<EventDetailsDto> findAllSportEvents();
    void saveWager(Wager wager);
    List<WagerDetailsDto> findAllWagers();
    void updatePlayer(Player player);
    void addChosenOutComeToPlayer(int chosen, double wagerAmount, int playerId);
    void deleteWagerById(int id);
}
