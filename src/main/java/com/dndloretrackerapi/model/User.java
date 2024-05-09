package com.dndloretrackerapi.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String username;
    private String password;

    @Transient
    boolean loggedIn;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Campaign> campaigns;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PlayerCharacter> playerCharacters;

    public User() {
    }
    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public List<PlayerCharacter> getPlayerCharacters() {
        return playerCharacters;
    }

    public void setPlayerCharacters(List<PlayerCharacter> playerCharacters) {
        this.playerCharacters = playerCharacters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isLoggedIn() == user.isLoggedIn() &&
                Objects.equals(getId(), user.getId()) &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getCampaigns(), user.getCampaigns()) &&
                Objects.equals(getPlayerCharacters(), user.getPlayerCharacters());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), isLoggedIn(), getCampaigns(), getPlayerCharacters());
    }
}
