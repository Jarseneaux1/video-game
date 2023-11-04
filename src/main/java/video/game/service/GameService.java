package video.game.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import video.game.entity.game;

@Service
public class GameService { 
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public game createGame(game game) {
        entityManager.persist(game);
        return game;
    }

    @Transactional
    public game getGameById(Long gameId) {
        return entityManager.find(game.class, gameId);
    }

    @Transactional
    public List<game> getAllGames() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<game> query = cb.createQuery(game.class);
        Root<game> root = query.from(game.class);
        query.select(root);
        TypedQuery<game> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    @Transactional
    public game updateGame(game game) {
        return entityManager.merge(game);
    }

    @Transactional
    public void deleteGame(Long gameId) {
        game game = entityManager.find(game.class, gameId);
        if (game != null) {
            entityManager.remove(game);
        }
    }

   
}