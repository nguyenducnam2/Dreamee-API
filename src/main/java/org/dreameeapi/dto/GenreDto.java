package org.dreameeapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.dreameeapi.entity.Genre;

@NoArgsConstructor
@Data
@ToString
public class GenreDto {
    int id;
    String name;

    public Genre get() {
        Genre genre = new Genre();
        genre.setId(id);
        genre.setName(name);
        return genre;
    }
}
