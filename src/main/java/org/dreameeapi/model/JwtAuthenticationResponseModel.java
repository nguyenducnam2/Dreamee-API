package org.dreameeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtAuthenticationResponseModel extends ResponseModel {
    String mess;
    String token;
    String type;
    long expired;

    public JwtAuthenticationResponseModel(String mess) {
        this.mess = mess;
    }
}
