package video.game.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_platform_id")
    private Long gamePlatformId;
    
    @Column(name = "platform_name")
    private String platformName;
    
    @ManyToOne
    @JoinColumn(name = "game_id")
    private game game;
    
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private genre genre;

    
}
