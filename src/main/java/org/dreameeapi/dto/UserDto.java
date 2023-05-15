package org.dreameeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.dreameeapi.entity.Role;
import org.dreameeapi.entity.User;

import java.util.List;

@AllArgsConstructor
@Data
@ToString
public class UserDto {
    int id;
    String username;
    String password;
    boolean enabled;
    boolean locked;
    String avatar;
    List<Role> roles;

    public User get() {
        return new User(id, username, password, enabled, locked, avatar, roles);
    }
}
