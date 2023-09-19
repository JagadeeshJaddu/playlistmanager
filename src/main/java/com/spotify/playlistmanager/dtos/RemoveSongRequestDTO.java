package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoveSongRequestDTO {
    private Long songId;
}
