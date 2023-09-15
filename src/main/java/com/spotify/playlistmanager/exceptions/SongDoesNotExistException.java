package com.spotify.playlistmanager.exceptions;

public class SongDoesNotExistException extends Exception{
    public String getMessage()
    {
        return "Song Does Not Exist!";
    }
}
