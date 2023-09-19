package com.spotify.playlistmanager.controllers;

import org.springframework.stereotype.Controller;
import com.spotify.playlistmanager.dtos.CreatePlaylistRequestDTO;
import com.spotify.playlistmanager.dtos.EntityType;
import com.spotify.playlistmanager.dtos.RemovePlaylistRequestDTO;
import com.spotify.playlistmanager.dtos.ResponseDTO;
import com.spotify.playlistmanager.dtos.ResponseType;
import com.spotify.playlistmanager.dtos.SongToPlaylistRequestDTO;
import com.spotify.playlistmanager.models.Playlist;
import com.spotify.playlistmanager.services.PlaylistService;

@Controller
public class PlaylistController {
    private PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    public ResponseDTO createPlaylist(CreatePlaylistRequestDTO createPlaylistRequestDTO)
    {
        Playlist playlist;
        ResponseDTO createPlaylistResponseDTO = new ResponseDTO();
        createPlaylistResponseDTO.setEntityType(EntityType.Playlist);
        createPlaylistResponseDTO.setResponseType(ResponseType.Addition);
        String name = createPlaylistRequestDTO.getName();
        try{
            playlist = playlistService.createPlaylist(name);
            createPlaylistResponseDTO.setEntityId(playlist.getId());
            createPlaylistResponseDTO.setStatus("SUCCESS");
        }
        catch(Exception e)
        {
            createPlaylistResponseDTO.setStatus("FAILURE");
            createPlaylistResponseDTO.setMessage(e.getMessage());
        }
        return createPlaylistResponseDTO;
    }

    public ResponseDTO addSongToPlayList(SongToPlaylistRequestDTO songToPlaylistRequestDTO)
    {
        Playlist playlist;
        Long playlistId = songToPlaylistRequestDTO.getPlaylistId();
        Long songId = songToPlaylistRequestDTO.getSongId();
        ResponseDTO songToPlaylistResponseDTO = new ResponseDTO();
        songToPlaylistResponseDTO.setEntityType(EntityType.Playlist);
        songToPlaylistResponseDTO.setResponseType(ResponseType.Addition);
        try{
            playlist = playlistService.addSongToPlaylist(playlistId, songId);
            songToPlaylistResponseDTO.setEntityId(playlist.getId());
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

    public ResponseDTO removeSongFromPlaylist(SongToPlaylistRequestDTO songToPlaylistRequestDTO)
    {
        Playlist playlist;
        Long playlistId = songToPlaylistRequestDTO.getPlaylistId();
        Long songId = songToPlaylistRequestDTO.getSongId();
        ResponseDTO songToPlaylistResponseDTO = new ResponseDTO();
        songToPlaylistResponseDTO.setEntityType(EntityType.Playlist);
        songToPlaylistResponseDTO.setResponseType(ResponseType.Removal);
        try{
            playlist = playlistService.removeSongFromPlaylist(playlistId, songId);
            songToPlaylistResponseDTO.setEntityId(playlist.getId());
            songToPlaylistResponseDTO.setStatus("SUCCESS");
        }
        catch(Exception e)
        {
            songToPlaylistResponseDTO.setStatus("FAILURE");
            songToPlaylistResponseDTO.setMessage(e.getMessage());
        }
        return songToPlaylistResponseDTO;
    }

    public ResponseDTO removePlaylist(RemovePlaylistRequestDTO removePlaylistRequestDTO)
    {
        Long playlistId = removePlaylistRequestDTO.getPlaylistId();
        ResponseDTO removePlaylistResponseDTO = new ResponseDTO();
        removePlaylistResponseDTO.setEntityType(EntityType.Playlist);
        removePlaylistResponseDTO.setResponseType(ResponseType.Removal);
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
