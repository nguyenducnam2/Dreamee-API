package org.dreameeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    String name;
    @Basic
    @Column(name = "audio", nullable = false, length = 200)
    String audio;

    @JsonIgnoreProperties("songs")
    @ManyToMany(mappedBy = "songs", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Genre> genres;
    @Transient
    @JsonIgnore
    @JsonIgnoreProperties("songs")
    @ManyToMany(mappedBy = "songs", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Album> albums;
    @Transient
    @JsonIgnore
    @JsonIgnoreProperties("songs")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "band_id")
    Band band;
}
