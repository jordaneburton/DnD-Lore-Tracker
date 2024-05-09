package com.dndloretrackerapi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PlayerCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    @Transient
    private Integer userId;
    private String background;
    private List<String> coreMemories;

}
