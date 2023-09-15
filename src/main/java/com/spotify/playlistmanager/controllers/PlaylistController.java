package com.spotify.playlistmanager.controllers;

import org.springframework.stereotype.Controller;
import com.spotify.playlistmanager.dtos.CreatePlaylistRequestDTO;
import com.spotify.playlistmanager.dtos.CreatePlaylistResponseDTO;
import com.spotify.playlistmanager.models.Playlist;
import com.spotify.playlistmanager.services.PlaylistService;

@Controller
public class PlaylistController {
    private PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    public CreatePlaylistResponseDTO createPlaylist(CreatePlaylistRequestDTO createPlaylistRequestDTO)
    {
        Playlist playlist;
        CreatePlaylistResponseDTO createPlaylistResponseDTO = new CreatePlaylistResponseDTO();
        String name = createPlaylistRequestDTO.getName();
        try{
            playlist = playlistService.createPlaylist(name);
            createPlaylistResponseDTO.setId(playlist.getId());
            createPlaylistResponseDTO.setStatus("SUCCESS");
        }
        catch(Exception e)
        {
            createPlaylistResponseDTO.setStatus("FAILURE");
            createPlaylistResponseDTO.setMessage(e.getMessage());
        }
        return createPlaylistResponseDTO;
    }
}
