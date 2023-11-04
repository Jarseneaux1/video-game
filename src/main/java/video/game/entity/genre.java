package video.game.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "genre_name")
    private String genreName;

    @ManyToMany
    @JoinTable(
        name = "genre_name",
        joinColumns = @JoinColumn(name = "genre_id"),
        inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<game> games;

    
}
