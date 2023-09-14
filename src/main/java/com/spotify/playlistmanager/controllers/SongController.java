package com.spotify.playlistmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.spotify.playlistmanager.dtos.AddSongRequestDTO;
import com.spotify.playlistmanager.dtos.AddSongResponseDTO;
import com.spotify.playlistmanager.models.Song;
import com.spotify.playlistmanager.services.SongService;

@Controller
public class SongController {
    private SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    public AddSongResponseDTO addSong(AddSongRequestDTO addSongRequestDTO) {
        Song song;
        AddSongResponseDTO addSongResponseDTO = new AddSongResponseDTO();
        String name = addSongRequestDTO.getName();
        Long artistId = addSongRequestDTO.getArtistId();
        Long albumId = addSongRequestDTO.getAlbumId();
        int duration = addSongRequestDTO.getDuration();
        try {
            song = songService.addSong(name, artistId, albumId,duration);
            addSongResponseDTO.setSongId(song.getId());
            addSongResponseDTO.setStatus("SUCCESS");
        } catch (Exception e) {
            addSongResponseDTO.setStatus("FAILURE");
            addSongResponseDTO.setMessage(e.getMessage());
            System.out.println(e.getMessage());
        }

        return addSongResponseDTO;
    }
}
