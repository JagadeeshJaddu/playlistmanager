package com.spotify.playlistmanager.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.spotify.playlistmanager.exceptions.AlbumAlreadyExistException;
import com.spotify.playlistmanager.exceptions.AlbumDoesNotExistException;
import com.spotify.playlistmanager.exceptions.ArtistDoesNotExistException;
import com.spotify.playlistmanager.exceptions.SongDoesNotExistException;
import com.spotify.playlistmanager.models.Album;
import com.spotify.playlistmanager.models.Artist;
import com.spotify.playlistmanager.models.Song;
import com.spotify.playlistmanager.repositories.AlbumRepository;
import com.spotify.playlistmanager.repositories.ArtistRepository;
import com.spotify.playlistmanager.repositories.SongRepository;

@Service
public class AlbumService {
    private ArtistRepository artistRepository;
    private AlbumRepository albumRepository;
    private SongRepository songRepository;

    public AlbumService(AlbumRepository albumRepository, ArtistRepository artistRepository,
            SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    public Album addAlbum(String name, Long artistId) throws ArtistDoesNotExistException, AlbumAlreadyExistException {
        Optional<Artist> artistOptional = artistRepository.findById(artistId);
        if (artistOptional.isEmpty()) {
            throw new ArtistDoesNotExistException();
        }

        Optional<Album> albumOptional = albumRepository.findByName(name);
        if (albumOptional.isPresent()) {
            throw new AlbumAlreadyExistException();
        }

        Album album = new Album();
        album.setName(name);
        album.setArtist(artistOptional.get());

        album = albumRepository.save(album);

        return album;
    }

    public Album addSongToAlbum(Long albumId, Long songId)
            throws AlbumDoesNotExistException, SongDoesNotExistException {
        Optional<Album> albumOptional = albumRepository.findById(albumId);
        if (albumOptional.isEmpty()) {
            throw new AlbumDoesNotExistException();
        }

        Optional<Song> songOptional = songRepository.findById(songId);
        if (songOptional.isEmpty()) {
            throw new SongDoesNotExistException();
        }

        Song song = songOptional.get();
        Album album = albumOptional.get();
        List<Song> albumSongs = album.getSongs();
        albumSongs.add(song);
        song.setAlbum(album);
        song = songRepository.save(song);
        album = albumRepository.save(album);

        return album;
    }

    public List<Album> findAlbumByArtist(Long artistId) throws ArtistDoesNotExistException
    {
        Optional<Artist> artistOptional = artistRepository.findById(artistId);
        if(artistOptional.isEmpty())
        {
            throw new ArtistDoesNotExistException();
        }
        Artist artist = artistOptional.get();
        List<Album> albums = albumRepository.findByArtist(artist);
        return albums;
    }

    public List<Album> findAllAlbums()
    {
        List<Album> albums = albumRepository.findAll();
        return albums;
    }
}
