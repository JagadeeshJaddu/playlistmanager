package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSongRequestDTO {
    private String name;
    private Long artistId;
    private int duration;
}
