package org.dreameeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @JsonIgnoreProperties("songs")
    @ManyToMany(mappedBy = "songs", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Genre> genre;
    @ManyToMany(mappedBy = "songs", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Album> albums;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "band_id")
    Band band;
}
