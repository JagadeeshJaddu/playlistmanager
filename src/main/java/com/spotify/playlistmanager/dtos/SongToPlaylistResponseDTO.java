package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongToPlaylistResponseDTO {
    private Long playlistId;
    private String status;
    private String message;
}
