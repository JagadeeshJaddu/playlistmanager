package com.spotify.playlistmanager.commands;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import com.spotify.playlistmanager.controllers.PlaylistController;
import com.spotify.playlistmanager.dtos.ResponseDTO;
import com.spotify.playlistmanager.dtos.SongToPlaylistRequestDTO;

@Component
public class SongToPlaylistCommand implements Command{
    private PlaylistController playlistController;

    public SongToPlaylistCommand(PlaylistController playlistController)
    {
        this.playlistController = playlistController;
    }
    @Override
    public boolean matches(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        if(inputWords.size()==3 && inputWords.get(0).equalsIgnoreCase(CommandKeyWords.songToPlatlist))
        {
            return true;
        }
        return false;
    }

    @Override
    public void excecute(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        Long playlistId = Long.parseLong(inputWords.get(1));
        Long songId = Long.parseLong(inputWords.get(2));
        SongToPlaylistRequestDTO songToPlaylistRequestDTO = new SongToPlaylistRequestDTO();
        songToPlaylistRequestDTO.setPlaylistId(playlistId);
        songToPlaylistRequestDTO.setSongId(songId);
        ResponseDTO songToPlaylistResponseDTO = playlistController.addSongToPlayList(songToPlaylistRequestDTO);
        System.out.println(songToPlaylistResponseDTO.getStatus());
        return ;
    }
    
}
