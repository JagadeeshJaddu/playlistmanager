package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAlbumRequestDTO {
    private String name;
    private Long artistId;
}
