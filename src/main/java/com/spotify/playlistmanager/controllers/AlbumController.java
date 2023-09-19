package com.spotify.playlistmanager.controllers;

import org.springframework.stereotype.Controller;
import com.spotify.playlistmanager.dtos.AddAlbumRequestDTO;
import com.spotify.playlistmanager.dtos.AddSongToAlbumRequestDTO;
import com.spotify.playlistmanager.dtos.EntityType;
import com.spotify.playlistmanager.dtos.ResponseDTO;
import com.spotify.playlistmanager.dtos.ResponseType;
import com.spotify.playlistmanager.models.Album;
import com.spotify.playlistmanager.services.AlbumService;

@Controller
public class AlbumController {
    private AlbumService albumService;

    public AlbumController(AlbumService albumService)
    {
        this.albumService = albumService;
    }

    public ResponseDTO addAlbum(AddAlbumRequestDTO addAlbumRequestDTO)
    {
        Album album;
        String name = addAlbumRequestDTO.getName();
        Long artistId = addAlbumRequestDTO.getArtistId();
        ResponseDTO addAlbumResponseDTO = new ResponseDTO();
        addAlbumResponseDTO.setEntityType(EntityType.Album);
        addAlbumResponseDTO.setResponseType(ResponseType.Addition);

        try{
            album = albumService.addAlbum(name, artistId);
            addAlbumResponseDTO.setEntityId(album.getId());
            addAlbumResponseDTO.setStatus("SUCCESS");
        }
        catch(Exception e)
        {
            addAlbumResponseDTO.setStatus("FAILURE");
            addAlbumResponseDTO.setMessage(e.getMessage());
        }

        return addAlbumResponseDTO;
    }

    public ResponseDTO addSongToAlbum(AddSongToAlbumRequestDTO addSongToAlbumRequestDTO)
    {
        Album album;
        ResponseDTO addSongToAlbumResponseDTO = new ResponseDTO();
        Long albumId = addSongToAlbumRequestDTO.getAlbumId();
        Long songId = addSongToAlbumRequestDTO.getSongId();
        addSongToAlbumResponseDTO.setEntityType(EntityType.Album);
        addSongToAlbumResponseDTO.setResponseType(ResponseType.Addition);
        try{
            album = albumService.addSongToAlbum(albumId, songId);
            addSongToAlbumResponseDTO.setEntityId(album.getId());
            addSongToAlbumResponseDTO.setStatus("SUCCESS");
        }
        catch(Exception e)
        {
            addSongToAlbumResponseDTO.setStatus("FAILURE");
            addSongToAlbumResponseDTO.setMessage(e.getMessage());
        }

        return addSongToAlbumResponseDTO;
    }
}
