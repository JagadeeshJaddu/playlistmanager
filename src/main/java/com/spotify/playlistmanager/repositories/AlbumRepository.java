package com.spotify.playlistmanager.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spotify.playlistmanager.models.Album;
import com.spotify.playlistmanager.models.Artist;
import java.util.List;


@Repository
public interface AlbumRepository extends JpaRepository<Album,Long>{
    Optional<Album> findById(Long id);
    Optional<Album>  findByName(String name);
    <S extends Album> S save(S Album);
    List<Album> findByArtist(Artist artist);
    List<Album> findAll();
}
