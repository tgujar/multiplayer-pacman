package com.game.mutliplayerpacman.dto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GameMapDto {
    private Long id;
    private String name;
    private Integer xdim;
    private Integer ydim;
    private GameCellDto[][] cells;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}