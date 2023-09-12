package com.spotify.playlistmanager.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Album extends BaseModel{
    private String name;
    @ManyToOne
    private Artist artist;
    @OneToMany
    private List<Song> songs;
}
