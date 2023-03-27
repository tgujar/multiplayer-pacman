package com.game.mutliplayerpacman.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameCellDto {
    private boolean left;
    private boolean down;
    private boolean right;
    private boolean up;

    private Power power;
}
