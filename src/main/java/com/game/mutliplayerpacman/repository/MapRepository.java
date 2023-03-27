package com.game.mutliplayerpacman.repository;

import com.game.mutliplayerpacman.models.GameMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MapRepository extends JpaRepository<GameMap, Long> {
    Optional<GameMap> findByName(String name);
}
