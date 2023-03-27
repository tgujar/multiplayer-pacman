package com.game.mutliplayerpacman.models;
import com.game.mutliplayerpacman.service.Coordinate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "gamemap")
public class GameMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer xdim;
    private Integer ydim;
    @Convert(converter = CoordinateListConverter.class)
    private List<Coordinate> wall;
    @Convert(converter = CoordinateListConverter.class)
    private List<Coordinate> cherry;
    @Convert(converter = CoordinateListConverter.class)
    private List<Coordinate> gpower;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
