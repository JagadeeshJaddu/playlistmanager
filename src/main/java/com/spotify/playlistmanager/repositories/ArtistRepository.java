package com.spotify.playlistmanager.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spotify.playlistmanager.models.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long>{
    Optional<Artist> findById(Long id);
    Optional<Artist> findByName(String name);
    List<Artist> findAll();
    <S extends Artist> S save(S Artist);
}
