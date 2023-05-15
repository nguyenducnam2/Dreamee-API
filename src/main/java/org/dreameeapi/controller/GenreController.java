package org.dreameeapi.controller;

import lombok.RequiredArgsConstructor;
import org.dreameeapi.dto.GenreDto;
import org.dreameeapi.response.GenreResponse;
import org.dreameeapi.response.MessResponse;
import org.dreameeapi.service.GenreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/genre")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public GenreResponse findAll() {
        return new GenreResponse(genreService.findAll());
    }

    @PostMapping("/save")
    public MessResponse save(@RequestBody GenreDto genre) {
        try {
            genreService.save(genre.get());
            return new MessResponse(true, "Successfully");
        } catch (Exception e) {
            return new MessResponse(false, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public MessResponse remove(@PathVariable("id") int id) {
        try {
            genreService.removeById(id);
            return new MessResponse(true, "Successfully");
        } catch (Exception e) {
            return new MessResponse(false, e.getMessage());
        }
    }
}
