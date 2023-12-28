package com.spotify.playlistmanager.models;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Document("albums")
public class Album extends BaseModel{
    private String name;
    @ManyToOne
    private Artist artist;
    @OneToMany(fetch = FetchType.EAGER , mappedBy = "album", cascade = CascadeType.REMOVE)
    @DBRef
    private List<Song> songs;

    /*@JsonManagedReference
    public List<Song> getSongs()
    {
        return this.songs;
    }

    @JsonManagedReference
    public Artist getArtist()
    {
        return this.artist;
    }*/
}
