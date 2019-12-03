package com.example.application.repository;

import com.example.domain.entities.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
    Player findByEmail(String name);

    Player findById(int id);
}
