package com.spotify.playlistmanager.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spotify.playlistmanager.models.Album;
import com.spotify.playlistmanager.models.Artist;
import com.spotify.playlistmanager.models.Song;
import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Long>{
    Optional<Song> findById(Long id);
    Optional<Song> findByName(String name);
    List<Song> findByArtist(Artist artist);
    /*@Query(value = "select * from song where album_id = ?1" , nativeQuery = true)
    List<Song> findByAlbum(Long albumId);*/
    List<Song> findAllByAlbum(Album album);
    List<Song> findAll();
    <S extends Song> S save(S Song);
}
