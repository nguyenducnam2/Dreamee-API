package org.dreameeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Basic
    @Column(name = "username")
    String username;
    @JsonIgnore
    @Basic
    @Column(name = "password")
    String password;
    @Basic
    @Column(name = "enabled")
    Boolean enabled;
    @Basic
    @Column(name = "locked")
    Boolean locked;
    @Basic
    @Column(name = "avatar")
    String avatar;

    @JsonIgnoreProperties("users")
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    List<Role> roles = new ArrayList<>();
}
