package com.spotify.playlistmanager.controllers;

import org.springframework.stereotype.Controller;
import com.spotify.playlistmanager.dtos.AddArtistRequestDTO;
import com.spotify.playlistmanager.dtos.EntityType;
import com.spotify.playlistmanager.dtos.ResponseDTO;
import com.spotify.playlistmanager.dtos.ResponseType;
import com.spotify.playlistmanager.models.Artist;
import com.spotify.playlistmanager.services.ArtistService;

@Controller
public class ArtistController {
    private ArtistService artistService;

    public ArtistController(ArtistService artistService)
    {
        this.artistService = artistService;
    }
    public ResponseDTO addArtist(AddArtistRequestDTO addArtistRequestDTO)
    {
        Artist artist;
        String name = addArtistRequestDTO.getName();
        ResponseDTO addArtistResponseDTO = new ResponseDTO();
        addArtistResponseDTO.setEntityType(EntityType.Artist);
        addArtistResponseDTO.setResponseType(ResponseType.Addition);
        try{
            artist = artistService.addArtist(name);
            addArtistResponseDTO.setEntityId(artist.getId());
            addArtistResponseDTO.setStatus("SUCCESS");
        }
        catch(Exception e){
            addArtistResponseDTO.setStatus("FAILURE");
            addArtistResponseDTO.setMessage(e.getMessage());
        }

        return addArtistResponseDTO;
    }
}
