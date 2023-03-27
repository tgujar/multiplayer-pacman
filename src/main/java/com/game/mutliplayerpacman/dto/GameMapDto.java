package com.game.mutliplayerpacman.dto;
import com.game.mutliplayerpacman.service.Coordinate;
import java.time.LocalDateTime;
import java.util.List;

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