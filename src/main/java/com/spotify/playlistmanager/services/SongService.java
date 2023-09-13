package com.spotify.playlistmanager.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spotify.playlistmanager.exceptions.AlbumDoesNotExistException;
import com.spotify.playlistmanager.exceptions.ArtistDoesNotExistException;
import com.spotify.playlistmanager.exceptions.SongAlreadyExistsException;
import com.spotify.playlistmanager.models.Album;
import com.spotify.playlistmanager.models.Artist;
import com.spotify.playlistmanager.models.Song;
import com.spotify.playlistmanager.repositories.AlbumRepository;
import com.spotify.playlistmanager.repositories.ArtistRepository;
import com.spotify.playlistmanager.repositories.SongRepository;

@Service
public class SongService {
    private SongRepository songRepository;
    private ArtistRepository artistRepository;
    private AlbumRepository albumRepository;

    @Autowired
    public SongService(SongRepository songRepository, ArtistRepository artistRepository,AlbumRepository albumRepository)
    {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }
    public Song addSong(String name, Long artistId, Long albumId,int duration) throws ArtistDoesNotExistException,SongAlreadyExistsException,AlbumDoesNotExistException
    {
        Optional<Artist> artistOptional = artistRepository.findById(artistId);

        if(artistOptional.isEmpty())
        {
            throw new ArtistDoesNotExistException();
        }

        Optional<Song> songOptional = songRepository.findByName(name);

        if(songOptional.isPresent())
        {
            throw new SongAlreadyExistsException();
        }

        Optional<Album> albumOptional = albumRepository.findById(albumId);;
        if(albumId !=-1 && albumOptional.isEmpty())
        {
            throw new AlbumDoesNotExistException();
        }

        Song song = new Song();

        song.setName(name);
        song.setArtist(artistOptional.get());
        song.setDuration(duration);
        if(albumId != -1)
        {
            song.setAlbum(albumOptional.get());
        }

        song = songRepository.save(song);

        return song;
    }
}
