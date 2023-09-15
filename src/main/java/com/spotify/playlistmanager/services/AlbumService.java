package com.spotify.playlistmanager.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.spotify.playlistmanager.exceptions.AlbumAlreadyExistException;
import com.spotify.playlistmanager.exceptions.ArtistDoesNotExistException;
import com.spotify.playlistmanager.models.Album;
import com.spotify.playlistmanager.models.Artist;
import com.spotify.playlistmanager.repositories.AlbumRepository;
import com.spotify.playlistmanager.repositories.ArtistRepository;

@Service
public class AlbumService {
    private ArtistRepository artistRepository;
    private AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository, ArtistRepository artistRepository)
    {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    public Album addAlbum(String name, Long artistId) throws ArtistDoesNotExistException,AlbumAlreadyExistException
    {
        Optional<Artist> artistOptional = artistRepository.findById(artistId);
        if(artistOptional.isEmpty())
        {
            throw new ArtistDoesNotExistException();
        }

        Optional<Album> albumOptional = albumRepository.findByName(name);
        if(albumOptional.isPresent())
        {
            throw new AlbumAlreadyExistException();
        }

        Album album = new Album();
        album.setName(name);
        album.setArtist(artistOptional.get());

        album = albumRepository.save(album);

        return album;
    }
}
