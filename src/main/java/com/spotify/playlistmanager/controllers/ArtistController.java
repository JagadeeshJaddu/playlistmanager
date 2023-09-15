package com.spotify.playlistmanager.controllers;

import org.springframework.stereotype.Controller;
import com.spotify.playlistmanager.dtos.AddArtistRequestDTO;
import com.spotify.playlistmanager.dtos.AddArtistResponseDTO;
import com.spotify.playlistmanager.models.Artist;
import com.spotify.playlistmanager.services.ArtistService;

@Controller
public class ArtistController {
    private ArtistService artistService;

    public ArtistController(ArtistService artistService)
    {
        this.artistService = artistService;
    }
    public AddArtistResponseDTO addArtist(AddArtistRequestDTO addArtistRequestDTO)
    {
        Artist artist;
        String name = addArtistRequestDTO.getName();
        AddArtistResponseDTO addArtistResponseDTO = new AddArtistResponseDTO();
        try{
            artist = artistService.addArtist(name);
            addArtistResponseDTO.setId(artist.getId());
            addArtistResponseDTO.setStatus("SUCCESS");
        }
        catch(Exception e){
            addArtistResponseDTO.setStatus("FAILURE");
            addArtistResponseDTO.setMessage(e.getMessage());
        }

        return addArtistResponseDTO;
    }
}
