package com.spotify.playlistmanager.models;

import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Document("songs")
public class Song extends BaseModel{
    private String name;
    @ManyToOne
    @JsonIgnore
    private Artist artist;
    @ManyToOne
    @JsonIgnore
    private Album album;
    private int duration;

    /*@JsonBackReference
    public Album getAlbum()
    {
        return this.album;
    }

    @JsonBackReference
    public Artist getArtist()
    {
        return this.artist;
    }*/
}
