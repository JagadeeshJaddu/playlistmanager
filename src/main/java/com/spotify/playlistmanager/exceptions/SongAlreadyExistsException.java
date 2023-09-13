package com.spotify.playlistmanager.exceptions;

public class SongAlreadyExistsException extends Exception{
    public String getMessage()
    {
        return "Song Already Exists!";
    }
}
