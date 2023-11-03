package video.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import video.game.entity.game;
import video.game.service.GameService; // Correct the import

@RestController
@RequestMapping("/api/games")
public class VideoGameController {
    @Autowired
    private GameService gameService; // Use the corrected import

    @PostMapping
    public game createGame(@RequestBody game game) {
        return gameService.createGame(game);
    }

    @GetMapping("/{gameId}")
    public game getGameById(@PathVariable Long gameId) {
        return gameService.getGameById(gameId);
    }

    @GetMapping
    public List<game> getAllGames() {
        return gameService.getAllGames();
    }

    @PutMapping
    public game updateGame(@RequestBody game game) {
        return gameService.updateGame(game);
    }

    @DeleteMapping("/{gameId}")
    public void deleteGame(@PathVariable Long gameId) {
        gameService.deleteGame(gameId);
    }



    // Other endpoints can be added as needed

    // Example: Retrieve all games for a specific genre
   // @GetMapping("/genre/{genreId}")
  //  public List<game> getGamesByGenre(@PathVariable Long genreId) {
     //   return gameService.getGamesByGenre(genreId);
    }
