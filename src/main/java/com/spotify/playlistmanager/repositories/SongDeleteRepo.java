package com.spotify.playlistmanager.repositories;

import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Component
public class SongDeleteRepo {
    public void deleteSong(Long songId)
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playlistmanagerfinal","root","Dampappa@2");
            Statement statement = con.createStatement();
            String sql1 = "DELETE FROM playlist_songs where songs_id = "+songId;
            int playlistDelete = statement.executeUpdate(sql1);
            String sql2 = "DELETE FROM song where id = "+songId;
            int songDelete = statement.executeUpdate(sql2);
            System.out.println(playlistDelete+" "+songDelete);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
