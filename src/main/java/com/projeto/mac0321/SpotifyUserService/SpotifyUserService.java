package com.projeto.mac0321.SpotifyUserService;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.special.SearchResult;
import se.michaelthelin.spotify.model_objects.specification.User;
import se.michaelthelin.spotify.requests.data.search.SearchItemRequest;
import se.michaelthelin.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;

import java.io.IOException;
import java.net.URI;

public class SpotifyUserService {
    private final SpotifyApi spotifyApi;

    public SpotifyUserService(String clientId, String clientSecret, URI redirectURI) {
        spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectUri(redirectURI)
                .build();
    }

    public void setAccessToken(String accessToken) {
        spotifyApi.setAccessToken(accessToken);
    }

    // To-do: Exception handling
    //		  set adequate access token before each operation
    public User getCurrentUser() {
        final GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = spotifyApi.getCurrentUsersProfile()
                .build();

        try {
            return getCurrentUsersProfileRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }
    }
}
