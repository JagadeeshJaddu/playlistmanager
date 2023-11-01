package com.spotify.playlistmanager.dtos;

import java.util.List;

import com.spotify.playlistmanager.models.Song;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindSongsByArtistResponseDTO {
    private List<Song> songs;
    private String status;
    private String message;
}
