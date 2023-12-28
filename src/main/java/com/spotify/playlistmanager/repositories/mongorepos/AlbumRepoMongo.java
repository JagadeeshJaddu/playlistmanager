package com.spotify.playlistmanager.repositories.mongorepos;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.spotify.playlistmanager.models.Album;

public interface AlbumRepoMongo extends MongoRepository<Long,Album>{
    
}
