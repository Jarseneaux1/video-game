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
import video.game.entity.platform;

@Service
public class GamePlatformService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public platform createGamePlatform(platform gamePlatform) {
        entityManager.persist(gamePlatform);
        return gamePlatform;
    }

    @Transactional
    public platform getGamePlatformById(Long gamePlatformId) {
        return entityManager.find(platform.class, gamePlatformId);
    }

    @Transactional
    public List<platform> getAllGamePlatforms() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<platform> query = cb.createQuery(platform.class);
        Root<platform> root = query.from(platform.class);
        query.select(root);
        TypedQuery<platform> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    @Transactional
    public platform updateGamePlatform(platform gamePlatform) {
        return entityManager.merge(gamePlatform);
    }

    @Transactional
    public void deleteGamePlatform(Long gamePlatformId) {
        platform gamePlatform = entityManager.find(platform.class, gamePlatformId);
        if (gamePlatform != null) {
            entityManager.remove(gamePlatform);
        }
    }

   
}

