package com.spotify.playlistmanager.dtos;

import java.util.List;
import com.spotify.playlistmanager.models.Album;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindAlbumsByArtistResponseDTO {
    private Long artistId;
    private List<Album> albums;
    private String status;
    private String message;
}
