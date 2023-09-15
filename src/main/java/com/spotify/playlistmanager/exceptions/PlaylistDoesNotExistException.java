package com.spotify.playlistmanager.exceptions;

public class PlaylistDoesNotExistException extends Exception{
    public String getMessage()
    {
        return "Playlist Does Not Exist!";
    }
}
