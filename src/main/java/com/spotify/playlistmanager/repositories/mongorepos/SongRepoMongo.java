package com.spotify.playlistmanager.repositories.mongorepos;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.spotify.playlistmanager.models.Song;

public interface SongRepoMongo extends MongoRepository<Long,Song>{
    
}
