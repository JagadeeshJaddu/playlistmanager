package com.spotify.playlistmanager.repositories.mongorepos;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.spotify.playlistmanager.models.Artist;

public interface ArtistRepoMongo extends MongoRepository<Long,Artist>{
    
}
