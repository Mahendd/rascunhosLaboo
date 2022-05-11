package com.projeto.mac0321.SpotifySearchService;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.special.SearchResult;
import se.michaelthelin.spotify.requests.data.search.SearchItemRequest;

import java.io.IOException;
import java.net.URI;

public class SpotifySearchService {
    private final SpotifyApi spotifyApi;

    public SpotifySearchService(String clientId, String clientSecret, URI redirectURI) {
        spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectUri(redirectURI)
                .build();
    }
    
    public void setAccessToken(String accessToken) {
        spotifyApi.setAccessToken(accessToken);
    }

    SearchResult searchItem(String searchTerm, String type) {
        final SearchItemRequest searchItemRequest = spotifyApi.searchItem(searchTerm, type)
                .build();

        try {
            return searchItemRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }
    }
}
