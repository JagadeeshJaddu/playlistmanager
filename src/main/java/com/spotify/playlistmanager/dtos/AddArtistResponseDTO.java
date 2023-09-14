package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddArtistResponseDTO {
    private Long id;
    private String status;
    private String message;
}
