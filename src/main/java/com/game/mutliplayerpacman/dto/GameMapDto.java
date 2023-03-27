package com.game.mutliplayerpacman.dto;
import com.game.mutliplayerpacman.service.impl.Coordinate;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class GameMapDto {
    private Long id;
    private String name;
    private Integer xdim;
    private Integer ydim;
    private List<Coordinate> wall;
    private List<Coordinate> cherry;
    private List<Coordinate> gpower;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}