package com.spotify.playlistmanager.commands;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CommandRegistry {
    List<Command> commandList;

    public CommandRegistry(AddSongCommand addSongCommand, AddArtistCommand addArtistCommand,
            AddAlbumCommand addAlbumCommand, CreatePlaylistCommand createPlaylistCommand,
            SongToPlaylistCommand songToPlaylistCommand, RemoveSongFromPlaylistCommand removeSongFromPlaylistCommand,
            RemovePlaylistCommand removePlaylistCommand, AddSongToAlbumCommand addSongToAlbumCommand) {
        this.commandList = new ArrayList<>();
        commandList.add(addSongCommand);
        commandList.add(addArtistCommand);
        commandList.add(addAlbumCommand);
        commandList.add(createPlaylistCommand);
        commandList.add(songToPlaylistCommand);
        commandList.add(removeSongFromPlaylistCommand);
        commandList.add(removePlaylistCommand);
        commandList.add(addSongToAlbumCommand);
    }

    public void excecute(String input) {
        for (Command command : commandList) {
            if (command.matches(input)) {
                command.excecute(input);
                return;
            }
        }

        return;
    }
}
