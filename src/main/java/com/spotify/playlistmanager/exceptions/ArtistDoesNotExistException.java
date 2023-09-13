package com.spotify.playlistmanager.exceptions;

public class ArtistDoesNotExistException extends Exception{
    public String getMessage()
    {
        return "Artist Does Not Exist!";
    }
}
