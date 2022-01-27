package ru.shop.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FilmDTO {

    Film film;

    List<Genre> genres;

}
