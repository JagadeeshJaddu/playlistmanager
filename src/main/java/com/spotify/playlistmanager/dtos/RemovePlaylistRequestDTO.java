package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemovePlaylistRequestDTO {
    private Long playlistId;
}
