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

    public ResponseDTO removeSong(RemoveSongRequestDTO removeSongRequestDTO)
    {
        Long songId = removeSongRequestDTO.getSongId();
        ResponseDTO removeSongResponseDTO = new ResponseDTO();
        removeSongResponseDTO.setEntityType(EntityType.Song);
        removeSongResponseDTO.setResponseType(ResponseType.Removal);
        try{
            songService.removeSong(songId);
            removeSongResponseDTO.setStatus("SUCCESS");
        }
        catch(Exception e)
        {
            removeSongResponseDTO.setStatus("FAILURE");
            removeSongResponseDTO.setMessage(e.getMessage());
        }
        return removeSongResponseDTO;
    }
}
