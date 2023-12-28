package com.spotify.playlistmanager.controllers;

import org.springframework.stereotype.Controller;
import com.spotify.playlistmanager.dtos.AddSongRequestDTO;
import com.spotify.playlistmanager.dtos.EntityType;
import com.spotify.playlistmanager.dtos.RemoveSongRequestDTO;
import com.spotify.playlistmanager.dtos.ResponseDTO;
import com.spotify.playlistmanager.dtos.ResponseType;
import com.spotify.playlistmanager.models.Song;
import com.spotify.playlistmanager.services.SongService;

@Controller
public class SongController {
    private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    public ResponseDTO addSong(AddSongRequestDTO addSongRequestDTO) {
        Song song;
        ResponseDTO addSongResponseDTO = new ResponseDTO();
        String name = addSongRequestDTO.getName();
        Long artistId = addSongRequestDTO.getArtistId();
        int duration = addSongRequestDTO.getDuration();
        addSongResponseDTO.setEntityType(EntityType.Song);
        addSongResponseDTO.setResponseType(ResponseType.Addition);
        try {
            song = songService.addSong(name, artistId,duration);
            addSongResponseDTO.setEntityId(song.getId());
            addSongResponseDTO.setStatus("SUCCESS");
        } catch (Exception e) {
            addSongResponseDTO.setStatus("FAILURE");
            addSongResponseDTO.setMessage(e.getMessage());
            System.out.println("Exception:"+e.getMessage());
        }

        return addSongResponseDTO;
    }

    public ResponseDTO deleteSong(RemoveSongRequestDTO removeSongRequestDTO)
    {
        Long songId = removeSongRequestDTO.getSongId();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setEntityType(EntityType.Song);
        responseDTO.setResponseType(ResponseType.Removal);
        try{
            songService.deleteSong(songId);
            responseDTO.setStatus("SUCCESS");
        }
        catch(Exception e)
        {
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
}
