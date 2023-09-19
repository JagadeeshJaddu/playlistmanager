package com.spotify.playlistmanager.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spotify.playlistmanager.models.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Long>{
    Optional<Playlist> findById(Long id);
    Optional<Playlist> findByName(String name);
    //Playlist save(Playlist playlist);
    <S extends Playlist> S save(S Playlist);

    //void deleteAllBySongId(Long songId);
    void deleteById(Long playlistId);
    //void deleteAllBySongs(Song song);

    //@Query("DELETE FROM playlist where songs= ?1")
    //void deleteAllBySongId(Song song);
}
