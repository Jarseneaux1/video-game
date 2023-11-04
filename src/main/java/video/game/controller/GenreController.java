package video.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import video.game.entity.genre;
import video.game.service.GenreService;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping
    public genre createGenre(@RequestBody genre genre) {
        return genreService.createGenre(genre);
    }

    @GetMapping("/{genreId}")
    public genre getGenreById(@PathVariable Long genreId) {
        return genreService.getGenreById(genreId);
    }

    @GetMapping
    public List<genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @PutMapping
    public genre updateGenre(@RequestBody genre genre) {
        return genreService.updateGenre(genre);
    }

    @DeleteMapping("/{genreId}")
    public void deleteGenre(@PathVariable Long genreId) {
        genreService.deleteGenre(genreId);
    }

    
}
