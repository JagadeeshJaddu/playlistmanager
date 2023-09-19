package com.spotify.playlistmanager.commands;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import com.spotify.playlistmanager.controllers.ArtistController;
import com.spotify.playlistmanager.dtos.AddArtistRequestDTO;
import com.spotify.playlistmanager.dtos.ResponseDTO;

@Component
public class AddArtistCommand implements Command{
    private ArtistController artistController;

    public AddArtistCommand(ArtistController artistController)
    {
        this.artistController = artistController;
    }
    @Override
    public boolean matches(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        if(inputWords.size()==2 && inputWords.get(0).equalsIgnoreCase(CommandKeyWords.addArtist))
        {
            return true;
        }
        return false;
    }

    @Override
    public void excecute(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        AddArtistRequestDTO addArtistRequestDTO = new AddArtistRequestDTO();
        addArtistRequestDTO.setName(inputWords.get(1));
        ResponseDTO addArtistResponseDTO = artistController.addArtist(addArtistRequestDTO);
        System.out.println(addArtistResponseDTO.getStatus());
    }
    
}
