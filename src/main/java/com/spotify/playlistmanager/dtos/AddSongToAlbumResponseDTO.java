package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSongToAlbumResponseDTO {
    private Long albumId;
    private String status;
    private String message;
}
