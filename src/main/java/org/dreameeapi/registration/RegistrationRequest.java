package org.dreameeapi.registration;

import org.hibernate.annotations.NaturalId;

public record RegistrationRequest(
        String firstName,
        String lastName,
        String password,
        String email,
        String role,
        boolean enabled) {
}

