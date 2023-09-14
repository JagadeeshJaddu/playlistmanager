package com.spotify.playlistmanager.exceptions;

public class ArtistAlreadyExistException extends Exception{
    public String getMessage()
    {
        return "Artist Already Exist!";
    }
}
