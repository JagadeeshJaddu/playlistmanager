package com.spotify.playlistmanager.commands;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandRegistry {
    List<Command> commandList;

    @Autowired
    public CommandRegistry(AddSongCommand addSongCommand, AddArtistCommand addArtistCommand, AddAlbumCommand addAlbumCommand)
    {
        this.commandList = new ArrayList<>();
        commandList.add(addSongCommand);
        commandList.add(addArtistCommand);
        commandList.add(addAlbumCommand);
    }

    public void excecute(String input)
    {
        for(Command command : commandList)
        {
            if(command.matches(input))
            {
                command.excecute(input);
                return;
            }
        }

        return;
    }
}
