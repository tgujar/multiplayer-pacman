package com.game.mutliplayerpacman.service.impl;

import com.game.mutliplayerpacman.dto.GameMapDto;
import com.game.mutliplayerpacman.models.GameMap;
import com.game.mutliplayerpacman.repository.GameMapRepository;
import com.game.mutliplayerpacman.service.GameMapService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameMapServiceImpl implements GameMapService {
    private final GameMapRepository gameMapRepository;

    public GameMapServiceImpl(GameMapRepository gameMapRepository) {
        this.gameMapRepository = gameMapRepository;
    }

    @Override
    public List<GameMapDto> findAllMaps() {
        List<GameMap> gamemaps = gameMapRepository.findAll();
        return gamemaps.stream().map(this::mapToGameMapDto).collect(Collectors.toList());
    }

    @Override
    public GameMapDto findMap(Long id) {
        Optional<GameMap> g = gameMapRepository.findById(id);
        return g.map(this::mapToGameMapDto).orElse(null);
    }

    @Override
    public GameMapDto saveMap(GameMapDto gmd) {
        GameMap gm = gameMapRepository.save(mapToGameMap(gmd));
        return mapToGameMapDto(gm);
    }

    private GameMapDto mapToGameMapDto(GameMap g) {
        GameMapDto gameMapDto = GameMapDto.builder()
                .id(g.getId())
                .name(g.getName())
                .xdim(g.getXdim())
                .ydim(g.getYdim())
                .cherry(g.getCherry())
                .wall(g.getWall())
                .gpower(g.getGpower())
                .createdOn(g.getCreatedOn())
                .updatedOn(g.getUpdatedOn())
                .build();
        return gameMapDto;
    }

    private GameMap mapToGameMap(GameMapDto g) {
        GameMap gameMap = GameMap.builder()
                .id(g.getId())
                .name(g.getName())
                .xdim(g.getXdim())
                .ydim(g.getYdim())
                .cherry(g.getCherry())
                .wall(g.getWall())
                .gpower(g.getGpower())
                .createdOn(g.getCreatedOn())
                .updatedOn(g.getUpdatedOn())
                .build();
        return gameMap;
    }
}
