package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSongResponseDTO {
    private Long songId;
    private String status;
    private String message;
}
