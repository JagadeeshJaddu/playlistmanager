package com.spotify.playlistmanager.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.spotify.playlistmanager.exceptions.ArtistAlreadyExistException;
import com.spotify.playlistmanager.models.Artist;
import com.spotify.playlistmanager.repositories.ArtistRepository;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository)
    {
        this.artistRepository = artistRepository;
    }

    public Artist addArtist(String name) throws ArtistAlreadyExistException
    {
        Optional<Artist> artistOptional = artistRepository.findByName(name);

        if(artistOptional.isPresent())
        {
            throw new ArtistAlreadyExistException();
        }

        Artist artist = new Artist();
        artist.setName(name);

        artist = artistRepository.save(artist);

        return artist;
    }
}
