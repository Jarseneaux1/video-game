package video.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import video.game.entity.platform;
import video.game.service.GamePlatformService;

@RestController
@RequestMapping("/api/game-platforms")
public class GamePlatformController {
    @Autowired
    private GamePlatformService gamePlatformService;

    @PostMapping
    public platform createGamePlatform(@RequestBody platform gamePlatform) {
        return gamePlatformService.createGamePlatform(gamePlatform);
    }

    @GetMapping("/{gamePlatformId}")
    public platform getGamePlatformById(@PathVariable Long gamePlatformId) {
        return gamePlatformService.getGamePlatformById(gamePlatformId);
    }

    @GetMapping
    public List<platform> getAllGamePlatforms() {
        return gamePlatformService.getAllGamePlatforms();
    }

    @PutMapping
    public platform updateGamePlatform(@RequestBody platform gamePlatform) {
        return gamePlatformService.updateGamePlatform(gamePlatform);
    }

    @DeleteMapping("/{gamePlatformId}")
    public void deleteGamePlatform(@PathVariable Long gamePlatformId) {
        gamePlatformService.deleteGamePlatform(gamePlatformId);
    }

    // Other endpoints can be added as needed
}
