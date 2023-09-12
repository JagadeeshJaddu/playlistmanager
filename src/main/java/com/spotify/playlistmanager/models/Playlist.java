package com.spotify.playlistmanager.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Playlist extends BaseModel{
    private String name;
    @ManyToMany
    private List<Song> songs;
}
