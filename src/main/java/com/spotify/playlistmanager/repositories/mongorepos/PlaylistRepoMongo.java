package com.spotify.playlistmanager.repositories.mongorepos;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.spotify.playlistmanager.models.Playlist;

public interface PlaylistRepoMongo extends MongoRepository<Long,Playlist>{
    
}
