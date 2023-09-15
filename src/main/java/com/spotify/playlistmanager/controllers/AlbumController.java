package com.spotify.playlistmanager.controllers;

import org.springframework.stereotype.Controller;
import com.spotify.playlistmanager.dtos.AddAlbumRequestDTO;
import com.spotify.playlistmanager.dtos.AddAlbumResponseDTO;
import com.spotify.playlistmanager.models.Album;
import com.spotify.playlistmanager.services.AlbumService;

@Controller
public class AlbumController {
    private AlbumService albumService;

    public AlbumController(AlbumService albumService)
    {
        this.albumService = albumService;
    }

    public AddAlbumResponseDTO addAlbum(AddAlbumRequestDTO addAlbumRequestDTO)
    {
        Album album;
        String name = addAlbumRequestDTO.getName();
        Long artistId = addAlbumRequestDTO.getArtistId();
        AddAlbumResponseDTO addAlbumResponseDTO = new AddAlbumResponseDTO();

        try{
            album = albumService.addAlbum(name, artistId);
            addAlbumResponseDTO.setId(album.getId());
            addAlbumResponseDTO.setStatus("SUCCESS");
        }
        catch(Exception e)
        {
            addAlbumResponseDTO.setStatus("FAILURE");
            addAlbumResponseDTO.setMessage(e.getMessage());
        }

        return addAlbumResponseDTO;
    }
}
