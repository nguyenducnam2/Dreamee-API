package org.dreameeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles = new ArrayList<>();
}
