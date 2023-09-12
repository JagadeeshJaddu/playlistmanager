package com.spotify.playlistmanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Song extends BaseModel{
    private String name;
    @ManyToOne
    private Artist artist;
    @ManyToOne
    private Album album;
    private int duration;
}
