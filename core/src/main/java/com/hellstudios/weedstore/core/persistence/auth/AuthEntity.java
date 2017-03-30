package com.hellstudios.weedstore.core.persistence.auth;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author strel
 */
@Entity
@Table(name = "authentication", schema = "online-store", catalog = "")
public class AuthEntity {

    private String token;
    private String email;
    private Calendar expirationDate;


    @Basic
    @Column(name = "token", nullable = false, unique = true)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Id
    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "expires", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }


    @Override
    public int hashCode() {
        int result = (token != null) ? token.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthEntity that = (AuthEntity) o;

        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (expirationDate != null ? !expirationDate.equals(that.expirationDate) : that.expirationDate != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "AuthEntity{" +
                "token='" + token + '\'' +
                ", email='" + email + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
