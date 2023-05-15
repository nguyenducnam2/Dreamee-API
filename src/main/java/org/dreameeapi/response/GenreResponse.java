package org.dreameeapi.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.dreameeapi.entity.Genre;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
@ToString
public class GenreResponse implements Response {

    private Set<String> genres;

    public GenreResponse(List<Genre> genres) {
        this.genres = genres.stream().map(Genre::getName).collect(Collectors.toSet());
    }
}
