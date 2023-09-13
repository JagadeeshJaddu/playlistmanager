package com.spotify.playlistmanager.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistry {
    List<Command> commandList;

    public CommandRegistry(AddSongCommand addSongCommand)
    {
        this.commandList = new ArrayList<>();
        commandList.add(addSongCommand);
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
