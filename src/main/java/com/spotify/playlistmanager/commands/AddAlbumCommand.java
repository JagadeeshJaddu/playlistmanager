package com.spotify.playlistmanager.commands;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spotify.playlistmanager.controllers.AlbumController;
import com.spotify.playlistmanager.dtos.AddAlbumRequestDTO;
import com.spotify.playlistmanager.dtos.AddAlbumResponseDTO;

@Component
public class AddAlbumCommand implements Command{
    private AlbumController albumController;

    @Autowired
    public AddAlbumCommand(AlbumController albumController)
    {
        this.albumController = albumController;
    }
    @Override
    public boolean matches(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        if(inputWords.size()==3 && inputWords.get(0).equalsIgnoreCase(CommandKeyWords.addAlbum))
        {
            return true;
        }
        return false;
    }

    @Override
    public void excecute(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        String name = inputWords.get(1);
        Long artistId = Long.parseLong(inputWords.get(2));

        AddAlbumRequestDTO addAlbumRequestDTO = new AddAlbumRequestDTO();
        addAlbumRequestDTO.setName(name);
        addAlbumRequestDTO.setArtistId(artistId);

        AddAlbumResponseDTO addAlbumResponseDTO = albumController.addAlbum(addAlbumRequestDTO);

        System.out.println(addAlbumResponseDTO.getStatus());
    }
    
}
