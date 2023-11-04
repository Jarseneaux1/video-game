package video.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import video.game.entity.genre;
import video.game.service.GenreService;

@RestController
@RequestMapping("/api/genres") //for ARC 
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping
    public genre createGenre(@RequestBody genre genre) { //Create 
        return genreService.createGenre(genre);
    }

    @GetMapping("/{genreId}")
    public genre getGenreById(@PathVariable Long genreId) { //Read 
        return genreService.getGenreById(genreId);
    }

    @GetMapping
    public List<genre> getAllGenres() { //Read 
        return genreService.getAllGenres();
    }

    @PutMapping
    public genre updateGenre(@RequestBody genre genre) { //Update 
        return genreService.updateGenre(genre);
    }

    @DeleteMapping("/{genreId}")
    public void deleteGenre(@PathVariable Long genreId) { //Delete 
        genreService.deleteGenre(genreId);
    }

    
}
