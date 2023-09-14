package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAlbumResponseDTO {
    private Long id;
    private String message;
    private String status;
}
