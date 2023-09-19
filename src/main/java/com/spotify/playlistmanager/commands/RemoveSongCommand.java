package com.spotify.playlistmanager.commands;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import com.spotify.playlistmanager.controllers.SongController;
import com.spotify.playlistmanager.dtos.RemoveSongRequestDTO;
import com.spotify.playlistmanager.dtos.ResponseDTO;

@Component
public class RemoveSongCommand implements Command{
    private SongController songController;

    public RemoveSongCommand(SongController songController)
    {
        this.songController = songController;
    }

    @Override
    public boolean matches(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        if(inputWords.size() == 2 && inputWords.get(0).equalsIgnoreCase(CommandKeyWords.removeSong))
        {
            return true;
        }
        return false;
    }

    @Override
    public void excecute(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        Long songId = Long.parseLong(inputWords.get(1));
        RemoveSongRequestDTO removeSongRequestDTO = new RemoveSongRequestDTO();
        removeSongRequestDTO.setSongId(songId);
        ResponseDTO removeSongResponseDTO = songController.removeSong(removeSongRequestDTO);
        
        System.out.println(removeSongResponseDTO.getStatus());

        return ;
    }
    
}
