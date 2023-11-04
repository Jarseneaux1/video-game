package video.game.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import video.game.entity.game;
import video.game.service.GameService; // Correct the import

@RestController
@RequestMapping("/api/games") //for ARC  
public class VideoGameController {
    @Autowired
    private GameService gameService; 

    @PostMapping
    public game createGame(@RequestBody game game) { //Create  
        return gameService.createGame(game);
    }

    @GetMapping("/{gameId}")
    public game getGameById(@PathVariable Long gameId) { //Read  
        return gameService.getGameById(gameId);
    }

    @GetMapping
    public List<game> getAllGames() { //Read 
        return gameService.getAllGames();
    }

    @PutMapping
    public game updateGame(@RequestBody game game) { //Update  
        return gameService.updateGame(game);
    }

    @DeleteMapping("/{gameId}")
    public void deleteGame(@PathVariable Long gameId) { //Delete  
        gameService.deleteGame(gameId);
    }



   

}
   // @GetMapping("/genre/{genreId}")
  //  public List<game> getGamesByGenre(@PathVariable Long genreId) {
     //   return gameService.getGamesByGenre(genreId);
    
