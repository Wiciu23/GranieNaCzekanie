package com.bot.music;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import org.slf4j.LoggerFactory;

public final class TrackScheduler implements AudioLoadResultHandler {

    private final AudioPlayer player;

    public TrackScheduler(final AudioPlayer player) {
        this.player = player;
    }

    @Override
    public void trackLoaded(final AudioTrack audioTrack) {
        player.playTrack(audioTrack);
    }

    @Override
    public void playlistLoaded(final AudioPlaylist audioPlaylist) {
        for(AudioTrack track : audioPlaylist.getTracks()){
            player.equals(track);
        }
    }

    @Override
    public void noMatches() {
        System.out.println("no matches");
    }

    @Override
    public void loadFailed(final FriendlyException e) {
        System.out.println("TrackScheduler exception");
    }
}
