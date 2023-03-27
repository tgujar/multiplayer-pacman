package com.game.mutliplayerpacman.controller;

import com.game.mutliplayerpacman.dto.GameMapDto;
import com.game.mutliplayerpacman.service.GameMapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/maps")
public class GameMapController {
    private final GameMapService gameMapService;

    public GameMapController(GameMapService gameMapService) {
        this.gameMapService = gameMapService;
    }

    @GetMapping("/")
    public List<GameMapDto> loadAllMaps() {
        return gameMapService.findAllMaps();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameMapDto> loadMap(@PathVariable(value="id") Long id) {
        GameMapDto gmd = gameMapService.findMap(id);
        if (gmd == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(gmd);
    }

    @PostMapping("/")
    public ResponseEntity<GameMapDto> saveMap(@RequestBody GameMapDto gmdto) {
        GameMapDto gmd = gameMapService.saveMap(gmdto);
        if (gmd == null) {
            return ResponseEntity.badRequest().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(gmd.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(gmd);
        }
    }

}
