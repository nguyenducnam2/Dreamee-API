package org.dreameeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "username", nullable = false, length = 20)
    private String username;
    @Basic
    @Column(name = "password", nullable = true, length = 100)
    @JsonIgnore
    private String password;
    @Basic
    @Column(name = "enabled", nullable = true)
    private Boolean enabled;
    @Basic
    @Column(name = "locked", nullable = true)
    private Boolean locked;
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Role> roles;

}
