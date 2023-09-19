package com.spotify.playlistmanager.models;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Playlist extends BaseModel{
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Song> songs;
}
