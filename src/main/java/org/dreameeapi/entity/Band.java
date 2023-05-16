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
@Table(name = "band")
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    String name;
    @Basic
    @Column(name = "image")
    String pic;
    @JsonIgnoreProperties("bands")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "band_artist",
            joinColumns = @JoinColumn(name = "band_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    List<Artist> artists;
    @JsonIgnoreProperties("band")
    @OneToMany(mappedBy = "band", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Album> albums;
    @JsonIgnoreProperties("band")
    @OneToMany(mappedBy = "band", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Song> songs;


}