package com.spotify.playlistmanager.exceptions;

public class AlbumAlreadyExistException extends Exception{
    public String getMessage()
    {
        return "Album Already Exist!";
    }
}
