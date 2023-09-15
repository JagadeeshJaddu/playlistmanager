package com.spotify.playlistmanager.exceptions;

public class PlaylistAlreadyExistException extends Exception{
    public String getMessage()
    {
        return "Playlist Already Exist!";
    }
}
