package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindAlbumsByArtistRequestDTO {
    private Long artistId;
}
