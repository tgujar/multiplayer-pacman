package com.game.mutliplayerpacman.repository;

import com.game.mutliplayerpacman.models.GameMap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameMapRepository extends JpaRepository<GameMap, Long> {
}
