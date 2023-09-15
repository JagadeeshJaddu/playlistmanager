package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePlaylistResponseDTO {
    private Long id;
    private String status;
    private String message;
}
