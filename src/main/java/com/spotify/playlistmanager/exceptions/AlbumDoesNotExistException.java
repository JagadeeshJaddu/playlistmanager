package com.spotify.playlistmanager.exceptions;

public class AlbumDoesNotExistException extends Exception{
    public String getMessage()
    {
        return "Album Does Not Exist!";
    }
}
