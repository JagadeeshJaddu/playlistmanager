package com.spotify.playlistmanager.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.spotify.playlistmanager.exceptions.PlaylistAlreadyExistException;
import com.spotify.playlistmanager.exceptions.PlaylistDoesNotExistException;
import com.spotify.playlistmanager.exceptions.SongDoesNotExistException;
import com.spotify.playlistmanager.models.Playlist;
import com.spotify.playlistmanager.models.Song;
import com.spotify.playlistmanager.repositories.PlaylistRepository;
import com.spotify.playlistmanager.repositories.SongRepository;

@Service
public class PlaylistService {
    private PlaylistRepository playlistRepository;
    private SongRepository songRepository;

    public PlaylistService(PlaylistRepository playlistRepository,SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    public Playlist createPlaylist(String name) throws PlaylistAlreadyExistException {
        Optional<Playlist> playlistOptional = playlistRepository.findByName(name);
        if (playlistOptional.isPresent()) {
            throw new PlaylistAlreadyExistException();
        }

        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist = playlistRepository.save(playlist);

        return playlist;
    }

    public Playlist addSongToPlaylist(Long playlistId, Long songId)
            throws SongDoesNotExistException, PlaylistDoesNotExistException {
        Optional<Song> songOptional = songRepository.findById(songId);
        if (songOptional.isEmpty()) {
            throw new SongDoesNotExistException();
        }
        Optional<Playlist> playlistOptional = playlistRepository.findById(playlistId);
        if(playlistOptional.isEmpty())
        {
            throw new PlaylistDoesNotExistException();
        }

        Playlist playlist = playlistOptional.get();
        List<Song> playlistSongs = playlist.getSongs();
        playlistSongs.add(songOptional.get());
        playlist.setSongs(playlistSongs);
        playlist = playlistRepository.save(playlist);
        return playlist;
    }
}
