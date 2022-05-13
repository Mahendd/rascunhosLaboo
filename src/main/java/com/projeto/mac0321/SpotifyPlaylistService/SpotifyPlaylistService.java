package com.projeto.mac0321.SpotifyPlaylistService;

import java.io.IOException;
import java.net.URI;
import com.google.gson.JsonArray;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.special.SnapshotResult;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.model_objects.specification.PlaylistSimplified;
import se.michaelthelin.spotify.requests.data.follow.legacy.UnfollowPlaylistRequest;
import se.michaelthelin.spotify.requests.data.playlists.*;

public class SpotifyPlaylistService {
    private final SpotifyApi spotifyApi;

    public SpotifyPlaylistService(String clientId, String clientSecret, URI redirectURI) {
        spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectUri(redirectURI)
                .build();
    }
    // To-do: Exception handling
    //		  set adequate access token before each operation

    public void setAccessToken(String accessToken) {
        spotifyApi.setAccessToken(accessToken);
    }

    public Playlist createPlaylist(String ownerId, String playlistName) {
        final CreatePlaylistRequest createPlaylistRequest = spotifyApi.createPlaylist(ownerId, playlistName)
                .build();
        try {
            return createPlaylistRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }

    }

    public String removePlaylist(String ownerId, String playlistId) { // Doesnt remove, just unfollows
        final UnfollowPlaylistRequest unfollowPlaylistRequest = spotifyApi.unfollowPlaylist(ownerId, playlistId)
                .build();
        try {
            return unfollowPlaylistRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }

    }

    public Paging<PlaylistSimplified> listPlaylists(String userId) {
        final GetListOfUsersPlaylistsRequest getListOfUsersPlaylistsRequest = spotifyApi.getListOfUsersPlaylists(userId)
                .build();
        try {
            return getListOfUsersPlaylistsRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }
    }

    public Playlist getPlaylist(String playlistId) {
        final GetPlaylistRequest getPlaylistRequest = spotifyApi.getPlaylist(playlistId).build();
        try {
            return getPlaylistRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }
    }

    public SnapshotResult insertItems(String[] uris, String playlistId) {
        final AddItemsToPlaylistRequest addItemsToPlaylistRequest = spotifyApi.addItemsToPlaylist(playlistId, uris)
                .build();
        try {
            return addItemsToPlaylistRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }

    }

    public SnapshotResult removeItems(JsonArray tracks, String playlistId) {
        final RemoveItemsFromPlaylistRequest removeItemsFromPlaylistRequest = spotifyApi.removeItemsFromPlaylist(playlistId, tracks)
                .build();
        try {
            return removeItemsFromPlaylistRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }
    }
}
