package com.spotify.playlistmanager.commands;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import com.spotify.playlistmanager.controllers.SongController;
import com.spotify.playlistmanager.dtos.AddSongRequestDTO;
import com.spotify.playlistmanager.dtos.ResponseDTO;

@Component
public class AddSongCommand implements Command{
    private SongController songController;

    public AddSongCommand(SongController songController)
    {
        this.songController = songController;
    }
    @Override
    public boolean matches(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        if(inputWords.size()==4 && inputWords.get(0).equalsIgnoreCase(CommandKeyWords.addSong))
        {
            System.out.println(CommandKeyWords.addSong);
            return true;
        }
        return false;
    }

    @Override
    public void excecute(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();

        String name = inputWords.get(1);
        Long artistId = Long.parseLong(inputWords.get(2));
        int duration = Integer.parseInt(inputWords.get(3));

        AddSongRequestDTO addSongRequestDTO = new AddSongRequestDTO();

        addSongRequestDTO.setName(name);
        addSongRequestDTO.setArtistId(artistId);
        addSongRequestDTO.setDuration(duration);

        ResponseDTO addSongResponseDTO = songController.addSong(addSongRequestDTO);

        System.out.println(addSongResponseDTO.getStatus());
        return;
    }
    
}
