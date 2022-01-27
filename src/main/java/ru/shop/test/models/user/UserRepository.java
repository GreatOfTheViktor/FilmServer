package ru.shop.test.models.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.shop.test.models.films.film.Film;

import java.awt.print.Pageable;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("select c " +
            "from User " +
            "c join fetch c.favoriteFilms " +
            "where c.username=?1")
    User findByUsernameFetch(String username);

    Boolean existsUsername(String username);

    @Query("select c.favoriteFilms " +
            "from User " +
            "c join c.favoriteFilms " +
            "where c.Id=?1")
    Page<Film> findByIdFetch(long userId, Pageable pageable);

    Page<User> findAllByUsernameLike(String username, Pageable pageable);

}
