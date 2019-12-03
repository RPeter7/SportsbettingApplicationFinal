package com.example.application.repository;

import com.example.domain.entities.SportEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportEventRepository extends CrudRepository<SportEvent, Integer> {
}
