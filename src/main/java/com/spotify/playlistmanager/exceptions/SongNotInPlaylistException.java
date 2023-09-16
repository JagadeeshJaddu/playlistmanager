package com.spotify.playlistmanager.exceptions;

public class SongNotInPlaylistException extends Exception{
    public String getMessage()
    {
        return "Song Not In Playlist!";
    }
}
