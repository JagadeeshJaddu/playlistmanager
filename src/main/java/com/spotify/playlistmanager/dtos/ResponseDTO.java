package com.spotify.playlistmanager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private Long entityId;
    private EntityType entityType;
    private String status;
    private String message;
    private ResponseType responseType;
}
