package com.game.mutliplayerpacman.models;

import com.game.mutliplayerpacman.dto.GameCellDto;
import com.game.mutliplayerpacman.dto.Power;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "gamecell")
public class GameCell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gamemap_id")
    private GameMap gamemap;


    @Column(name="`row`")
    private int row;
    private int col;

    @Column(name="`left`")
    private boolean left;
    private boolean down;
    @Column(name="`right`")
    private boolean right;
    private boolean up;
    private Power power;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
