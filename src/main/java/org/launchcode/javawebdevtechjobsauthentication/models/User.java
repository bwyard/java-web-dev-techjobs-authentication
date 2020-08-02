package org.launchcode.javawebdevtechjobsauthentication.models;

import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity{



    private String username;

    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {
    }

    public User(String username, @Size(min = 5) String pwHash) {
        this.username = username;
        this.pwHash = encoder.encode(pwHash);
    }

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password){
        return encoder.matches(password, pwHash);
    }


}
