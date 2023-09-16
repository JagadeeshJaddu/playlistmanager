package com.spotify.playlistmanager.controllers;

import org.springframework.stereotype.Controller;
import com.spotify.playlistmanager.dtos.CreatePlaylistRequestDTO;
import com.spotify.playlistmanager.dtos.CreatePlaylistResponseDTO;
import com.spotify.playlistmanager.dtos.RemovePlaylistRequestDTO;
import com.spotify.playlistmanager.dtos.RemovePlaylistResponseDTO;
import com.spotify.playlistmanager.dtos.SongToPlaylistRequestDTO;
import com.spotify.playlistmanager.dtos.SongToPlaylistResponseDTO;
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

    public SongToPlaylistResponseDTO addSongToPlayList(SongToPlaylistRequestDTO songToPlaylistRequestDTO)
    {
        Playlist playlist;
        Long playlistId = songToPlaylistRequestDTO.getPlaylistId();
        Long songId = songToPlaylistRequestDTO.getSongId();
        SongToPlaylistResponseDTO songToPlaylistResponseDTO = new SongToPlaylistResponseDTO();
        try{
            playlist = playlistService.addSongToPlaylist(playlistId, songId);
            songToPlaylistResponseDTO.setPlaylistId(playlist.getId());
            songToPlaylistResponseDTO.setStatus("SUCCESS");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            songToPlaylistResponseDTO.setStatus("FAILURE");
            songToPlaylistResponseDTO.setMessage(e.getMessage());
        }
        return songToPlaylistResponseDTO;
    }

    public SongToPlaylistResponseDTO removeSongFromPlaylist(SongToPlaylistRequestDTO songToPlaylistRequestDTO)
    {
        Playlist playlist;
        Long playlistId = songToPlaylistRequestDTO.getPlaylistId();
        Long songId = songToPlaylistRequestDTO.getSongId();
        SongToPlaylistResponseDTO songToPlaylistResponseDTO = new SongToPlaylistResponseDTO();
        try{
            playlist = playlistService.removeSongFromPlaylist(playlistId, songId);
            songToPlaylistResponseDTO.setPlaylistId(playlist.getId());
            songToPlaylistResponseDTO.setStatus("SUCCESS");
        }
        catch(Exception e)
        {
            songToPlaylistResponseDTO.setStatus("FAILURE");
            songToPlaylistResponseDTO.setMessage(e.getMessage());
        }
        return songToPlaylistResponseDTO;
    }

    public RemovePlaylistResponseDTO removePlaylist(RemovePlaylistRequestDTO removePlaylistRequestDTO)
    {
        Long playlistId = removePlaylistRequestDTO.getPlaylistId();
        RemovePlaylistResponseDTO removePlaylistResponseDTO = new RemovePlaylistResponseDTO();
        try
        {
            playlistService.removePlaylist(playlistId);
            removePlaylistResponseDTO.setStatus("SUCCESS");
        }
        catch(Exception e)
        {
            removePlaylistResponseDTO.setStatus("FAILURE");
            removePlaylistResponseDTO.setMessage(e.getMessage());
        }

        return removePlaylistResponseDTO;
    }
}
