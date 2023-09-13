package com.spotify.playlistmanager.commands;

public interface Command {
    boolean matches(String input);

    void excecute(String input);
}
