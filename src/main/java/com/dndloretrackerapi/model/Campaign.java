package com.dndloretrackerapi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    @Transient
    private Integer dungeonMasterUserId;
    private String introduction;


    @OneToMany(mappedBy = "campaignId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PlayerCharacter> playerCharacters;
}
