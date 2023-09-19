package com.spotify.playlistmanager.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.spotify.playlistmanager.exceptions.ArtistDoesNotExistException;
import com.spotify.playlistmanager.exceptions.SongAlreadyExistsException;
import com.spotify.playlistmanager.exceptions.SongDoesNotExistException;
import com.spotify.playlistmanager.models.Artist;
import com.spotify.playlistmanager.models.Song;
import com.spotify.playlistmanager.repositories.AlbumRepository;
import com.spotify.playlistmanager.repositories.ArtistRepository;
import com.spotify.playlistmanager.repositories.PlaylistRepository;
import com.spotify.playlistmanager.repositories.SongRepository;

@Service
public class SongService {
    private SongRepository songRepository;
    private ArtistRepository artistRepository;
    //private AlbumRepository albumRepository;
    //private PlaylistRepository playlistRepository;

    public SongService(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository, PlaylistRepository playlistRepository)
    {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        //this.albumRepository = albumRepository;
        //this.playlistRepository = playlistRepository;
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

    public void removeSong(Long songId) throws SongDoesNotExistException
    {
        Optional<Song> songOptional = songRepository.findById(songId);
        if(songOptional.isEmpty())
        {
            throw new SongDoesNotExistException();
        }

        Song song = songOptional.get();
        Long Id = song.getId();
        songRepository.deleteById(Id);
        //albumRepository.deleteAllBySongs(song);
        //playlistRepository.deleteAllBySongs(song);
        //playlistRepository.deleteAllBySongId(song);
        return ;
    }
}
