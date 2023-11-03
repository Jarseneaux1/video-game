package video.game.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;
    
    @Column(name = "game_name")
    private String gameName;
    
    @Column(name = "hours_played")
    private int hoursPlayed;
    
    // Define relationships and getters/setters
}