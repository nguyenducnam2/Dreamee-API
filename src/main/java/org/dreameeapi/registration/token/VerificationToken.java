package org.dreameeapi.registration.token;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.dreameeapi.entity.User;

import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "verification_token")
public class VerificationToken {

    private static final int EXPIRATION_TIME = 15;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String token;
    Date expiration;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    public VerificationToken(String token) {
        this.token = token;
        this.expiration = this.getTokenExpirationTime();
    }

    public VerificationToken(String token, User user) {
        this.token = token;
        this.user = user;
        this.expiration = this.getTokenExpirationTime();
    }

    private Date getTokenExpirationTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, EXPIRATION_TIME);
        return new Date(calendar.getTime().getTime());
    }
}
