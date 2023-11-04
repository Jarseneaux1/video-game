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
import video.game.entity.genre;

@Service
public class GenreService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public genre createGenre(genre genre) {
        entityManager.persist(genre);
        return genre;
    }

    @Transactional
    public genre getGenreById(Long genreId) {
        return entityManager.find(genre.class, genreId);
    }

    @Transactional
    public List<genre> getAllGenres() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<genre> query = cb.createQuery(genre.class);
        Root<genre> root = query.from(genre.class);
        query.select(root);
        TypedQuery<genre> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    @Transactional
    public genre updateGenre(genre genre) {
        return entityManager.merge(genre);
    }

    @Transactional
    public void deleteGenre(Long genreId) {
        genre genre = entityManager.find(genre.class, genreId);
        if (genre != null) {
            entityManager.remove(genre);
        }
    }

   
}
