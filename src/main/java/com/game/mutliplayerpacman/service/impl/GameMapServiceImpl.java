package com.game.mutliplayerpacman.service.impl;

import com.game.mutliplayerpacman.dto.GameCellDto;
import com.game.mutliplayerpacman.dto.GameMapDto;
import com.game.mutliplayerpacman.models.GameCell;
import com.game.mutliplayerpacman.models.GameMap;
import com.game.mutliplayerpacman.repository.GameMapRepository;
import com.game.mutliplayerpacman.service.GameMapService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return gamemaps.stream().map(this::toGameMapDto).collect(Collectors.toList());
    }

    @Override
    public GameMapDto findMap(Long id) {
        Optional<GameMap> g = gameMapRepository.findById(id);
        return g.map(this::toGameMapDto).orElse(null);
    }

    @Override
    public GameMapDto saveMap(GameMapDto gmd) {
        GameMap gm = gameMapRepository.save(toGameMap(gmd));
        return toGameMapDto(gm);
    }

    @Override
    public GameMapDto generateRandomMap(int x, int y) {
        return saveMap(MapGen.random(x, y));
    }

    private GameMapDto toGameMapDto(GameMap g) {
        GameMapDto gameMapDto = GameMapDto.builder()
                .id(g.getId())
                .name(g.getName())
                .xdim(g.getXdim())
                .ydim(g.getYdim())
                .cells(toGameCellDtoMatrix(g.getCells(), g.getXdim(), g.getYdim()))
                .createdOn(g.getCreatedOn())
                .updatedOn(g.getUpdatedOn())
                .build();
        return gameMapDto;
    }

    private GameMap toGameMap(GameMapDto g) {
        GameMap gameMap = GameMap.builder()
                .id(g.getId())
                .name(g.getName())
                .xdim(g.getXdim())
                .ydim(g.getYdim())
                .createdOn(g.getCreatedOn())
                .updatedOn(g.getUpdatedOn())
                .build();
        gameMap.setCells(toGameCellList(g.getCells(), gameMap));
        return gameMap;
    }

    private GameCellDto[][] toGameCellDtoMatrix(List<GameCell> cl, int xdim, int ydim) {
        GameCellDto[][] gcm = new GameCellDto[ydim][xdim];
        for (GameCell gc: cl) {
            int row = gc.getRow();
            int col = gc.getCol();
            gcm[row][col] = GameCellDto.builder()
                    .up(gc.isUp())
                    .down(gc.isDown())
                    .left(gc.isLeft())
                    .right(gc.isRight())
                    .power(gc.getPower())
                    .build();
        }
        return gcm;
    }

    private List<GameCell> toGameCellList(GameCellDto[][] gcm, GameMap gm) {
        List<GameCell> lgc= new ArrayList<>();
        for (int i = 0; i < gcm.length; i++) {
            for (int j = 0; j < gcm[0].length; j++) {
                lgc.add(GameCell.builder()
                                .col(j)
                                .row(i)
                                .gamemap(gm)
                                .up(gcm[i][j].isUp())
                                .down(gcm[i][j].isDown())
                                .left(gcm[i][j].isLeft())
                                .right(gcm[i][j].isRight())
                                .power(gcm[i][j].getPower())
                                .build());
            }
        }
        return lgc;
    }
}
