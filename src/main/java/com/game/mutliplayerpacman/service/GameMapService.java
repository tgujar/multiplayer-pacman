package com.game.mutliplayerpacman.service;

import com.game.mutliplayerpacman.dto.GameMapDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GameMapService {
    List<GameMapDto> findAllMaps();
    GameMapDto findMap(Long id);
    GameMapDto saveMap(GameMapDto gm);

    GameMapDto generateRandomMap(int x, int y);
}
