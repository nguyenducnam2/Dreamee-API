package org.dreameeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Basic
    @Column(name = "name", nullable = false, length = 150)
    String name;
    @Basic
    @Column(name = "release_date")
    Date releaseDate;
    @Basic
    @Column(name = "pic", length = 200)
    String pic;
    @JsonIgnoreProperties("albums")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "album_song",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    List<Song> songs;
    @JsonIgnoreProperties("albums")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "band_id")
    Band band;
    @JsonIgnoreProperties("albums")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id")
    Artist artist;

}
