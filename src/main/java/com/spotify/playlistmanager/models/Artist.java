package com.spotify.playlistmanager.models;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Document("artists")
public class Artist extends BaseModel{
    private String name;
}
