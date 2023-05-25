package org.yearup;

import java.util.ArrayList;
import java.util.List;

public class MP3Player implements Playable, Player
{
    private List<Song> playlist;
    private Song currentSong;

    public MP3Player()
    {
        playlist = new ArrayList<>();
    }

    public void addToPlaylist(Song song)
    {
        playlist.add(song);
    }

    @Override
    public void play()
    {
        if(playlist.size() > 0)
        {
            currentSong = playlist.get(0);
            currentSong.play();
        }
        else
        {
            System.out.println("There are no songs in the playlist");
        }

    }

    @Override
    public void stop()
    {
        if(currentSong != null)
        {
            currentSong.stop();
        }
        else
        {
            System.out.println("You currently have no song selected");
        }
    }

    @Override
    public void play(Song song)
    {
        currentSong = song;
        currentSong.play();
    }
}
