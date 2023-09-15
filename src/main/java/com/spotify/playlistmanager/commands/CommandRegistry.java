package com.spotify.playlistmanager.commands;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CommandRegistry {
    List<Command> commandList;

    public CommandRegistry(AddSongCommand addSongCommand, AddArtistCommand addArtistCommand,
            AddAlbumCommand addAlbumCommand, CreatePlaylistCommand createPlaylistCommand) {
        this.commandList = new ArrayList<>();
        commandList.add(addSongCommand);
        commandList.add(addArtistCommand);
        commandList.add(addAlbumCommand);
        commandList.add(createPlaylistCommand);
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
