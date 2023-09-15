package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongToPlaylistRequestDTO {
    private Long playlistId;
    private Long songId;
}
