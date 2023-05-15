package org.dreameeapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtAuthenticationResponse extends MessResponse implements Response {
    boolean status;
    String mess;
    String token;
    String type;
    long expired;
    
}
