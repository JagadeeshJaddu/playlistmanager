package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSongToAlbumRequestDTO {
    private Long songId;
    private Long albumId;
}
