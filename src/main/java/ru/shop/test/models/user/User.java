package ru.shop.test.models.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.shop.test.models.films.film.Film;

import javax.xml.stream.events.Comment;
import java.time.LocalDate;
import java.util.*;

import static java.time.temporal.ChronoUnit.YEARS;


@Entity(name = "User")
@Table(name = "users")
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private Long Id;

    private final Set<Film> favoriteFilm = new HashSet<>();

    private final List<Comment> userComments = new ArrayList<>();

    private String username;

    private String email;

    private String password;

    private LocalDate subscriptionDeadline;

    private LocalDate dateOfBirth;

    private Professional professional;

    private int age;

    private Set<AuthRole> authRoles = new HashSet<>();

    private String avatar;

    public User(String email,
                String username,
                String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String email,
                String username,
                String password,
                LocalDate subscriptionDeadline,
                LocalDate dateOfBirth) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.subscriptionDeadline = subscriptionDeadline;
        this.dateOfBirth = dateOfBirth;
    }

    public User(String email,
                String username,
                String password,
                LocalDate subscriptionDeadline,
                LocalDate dateOfBirth,
                Set<AuthRole> authRoles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.subscriptionDeadline = subscriptionDeadline;
        this.dateOfBirth = dateOfBirth;
        this.authRoles = authRoles;
    }

    public int getAge() {
        return (int) YEARS.between(dateOfBirth, LocalDate.now());
    }

    public void addFavorite(Film film) {
        this.favoriteFilm.add(film);
    }

    public void removeFavorite(Film film) {
        this.favoriteFilm.remove(film);
    }

    public boolean isNull() {
        return this.username == null || this.email == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Id == user.Id && username.equals(user.username) && email.equals(user.email) && password.equals(user.password) && Objects.equals(subscriptionDeadline, user.subscriptionDeadline) && dateOfBirth.equals(user.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, username, email, password, dateOfBirth);
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", login='" + email + '\'' +
                ", subscriptionDeadline=" + subscriptionDeadline +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                '}';
    }
}
