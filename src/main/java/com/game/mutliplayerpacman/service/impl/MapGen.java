package com.game.mutliplayerpacman.service.impl;

import com.game.mutliplayerpacman.dto.GameCellDto;
import com.game.mutliplayerpacman.dto.GameMapDto;
import com.game.mutliplayerpacman.dto.Power;

import java.util.Random;

public class MapGen {
    public static GameMapDto random(int x, int y) {
        GameCellDto[][] map = new GameCellDto[y][x];
        Random rd = new Random();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                map[i][j] = GameCellDto.builder()
                        .left(j == 0 ? rd.nextBoolean(): map[i][j-1].isRight()) // make sure walls match previous placed
                        .right(rd.nextBoolean())
                        .up(i == 0 ? rd.nextBoolean(): map[i-1][j].isUp())
                        .down(rd.nextBoolean())
                        .power(Power.NONE)
                        .build();
            }
        }

        return GameMapDto.builder()
                .cells(map)
                .xdim(x)
                .ydim(y)
                .name("random")
                .build();
    }
}
