package org.dreameeapi.controller;

import lombok.RequiredArgsConstructor;
import org.dreameeapi.entity.Song;
import org.dreameeapi.service.SongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/song")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping
    public List<Song> findAll() {
        return songService.findAll();
    }
}
