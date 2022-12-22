package es.uah.cFilmsActores.model;

import es.uah.cFilmsActores.model.Critica;

import java.util.List;
import java.util.Objects;

public class User {

private Integer idUser;

private String username;

private String password;


private String email;

private boolean enable;


private List<Critica> criticas;

    public User(Integer idUser, String username, String password, String email, boolean enable) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.email = email;
    }
    public User () {

    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Critica> getCriticas() {
        return criticas;
    }

    public void setCriticas(List<Critica> criticas) {
        this.criticas = criticas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser != null && Objects.equals(idUser, user.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser);
    }
}
