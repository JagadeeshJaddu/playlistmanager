package com.spotify.playlistmanager.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Artist {
    private String name;
}
