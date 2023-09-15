package com.spotify.playlistmanager.commands;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import com.spotify.playlistmanager.controllers.SongController;
import com.spotify.playlistmanager.dtos.AddSongRequestDTO;
import com.spotify.playlistmanager.dtos.AddSongResponseDTO;

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
        if(inputWords.size()==5 && inputWords.get(0).equalsIgnoreCase(CommandKeyWords.addSong))
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
        Long albumId = Long.parseLong(inputWords.get(3));
        int duration = Integer.parseInt(inputWords.get(4));

        AddSongRequestDTO addSongRequestDTO = new AddSongRequestDTO();

        addSongRequestDTO.setName(name);
        addSongRequestDTO.setArtistId(artistId);
        addSongRequestDTO.setAlbumId(albumId);
        addSongRequestDTO.setDuration(duration);

        AddSongResponseDTO addSongResponseDTO = songController.addSong(addSongRequestDTO);

        System.out.println(addSongResponseDTO.getStatus());
        return;
    }
    
}
