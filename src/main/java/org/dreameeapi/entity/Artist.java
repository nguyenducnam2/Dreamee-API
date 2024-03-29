package org.dreameeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    String name;
    @Basic
    @Column(name = "pic")
    String pic;
    @JsonIgnoreProperties("artists")
    @ManyToMany(mappedBy = "artists", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Band> band;
    @JsonIgnoreProperties("artist")
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Album> albums;
}
