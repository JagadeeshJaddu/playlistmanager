package com.spotify.playlistmanager.services;

import java.util.List;
import java.util.Optional;
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

    public SongService(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository)
    {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }
    public Song addSong(String name, Long artistId,int duration) throws ArtistDoesNotExistException,SongAlreadyExistsException
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

        Song song = new Song();

        song.setName(name);
        song.setArtist(artistOptional.get());
        song.setDuration(duration);
        song = songRepository.save(song);

        return song;
    }

    public List<Song> findAllSongs()
    {
        List<Song> songs = songRepository.findAll();
        return songs;
    }

    public List<Song> findSongsByAlbum(Long albumId) throws AlbumDoesNotExistException
    {
        Optional<Album> albumOptional = albumRepository.findById(albumId);
        if(albumOptional.isEmpty())
        {
            throw new AlbumDoesNotExistException();
        }
        Album album = albumOptional.get();
        List<Song> songs = songRepository.findAllByAlbum(album);
        return songs;
    }

    public List<Song> findSongsByArtist(Long artistId) throws ArtistDoesNotExistException
    {
        Optional<Artist> artistOptional = artistRepository.findById(artistId);
        if(artistOptional.isEmpty())
        {
            throw new ArtistDoesNotExistException();
        }
        Artist artist = artistOptional.get();
        List<Song> songs = songRepository.findByArtist(artist);
        return songs;
    }
}
