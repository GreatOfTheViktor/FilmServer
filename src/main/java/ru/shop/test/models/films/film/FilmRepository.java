package ru.shop.test.models.films.film;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository {

    Page<Film> findAllByTitleLike(String search, Pageable pageable);

}
