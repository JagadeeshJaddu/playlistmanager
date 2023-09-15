package com.spotify.playlistmanager.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spotify.playlistmanager.exceptions.PlaylistAlreadyExistException;
import com.spotify.playlistmanager.models.Playlist;
import com.spotify.playlistmanager.repositories.PlaylistRepository;

@Service
public class PlaylistService {
    private PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository)
    {
        this.playlistRepository = playlistRepository;
    }

    public Playlist createPlaylist(String name) throws PlaylistAlreadyExistException
    {
        Optional<Playlist> playlistOptional = playlistRepository.findByName(name);
        if(playlistOptional.isPresent())
        {
            throw new PlaylistAlreadyExistException();
        }

        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist = playlistRepository.save(playlist);

        return playlist;
    }
}
