package com.projeto.mac0321.SpotifyAuthorizationService;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class AuthorizationCodeUri {
    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId("4393b004b1b343d3a7700b5c566041f0")
            .setClientSecret("s3cr3t")
            .setRedirectUri(URI.create("http://localhost:8080"))
            .build();

    public SpotifyApi call() {
        authorizationCodeUri_Sync();
        return spotifyApi;
    }

    private static final AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
            .state("x4xkmn9pu3j6ukrs8n")
            .scope("user-read-recently-played,user-read-playback-position,app-remote-control,user-read-playback-state,streaming,playlist-modify-public,user-library-modify,user-read-currently-playing,user-library-read,playlist-read-private,playlist-modify-private")
            .build();

    public static void authorizationCodeUri_Sync() {
        final URI uri = authorizationCodeUriRequest.execute();

        System.out.println("URI: " + uri.toString());
    }

    public static void authorizationCodeUri_Async() {
        try {
            final CompletableFuture<URI> uriFuture = authorizationCodeUriRequest.executeAsync();

            // Thread free to do other tasks...

            // Example Only. Never block in production code.
            final URI uri = uriFuture.join();

            System.out.println("URI: " + uri.toString());
        } catch (CompletionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        } catch (CancellationException e) {
            System.out.println("Async operation cancelled.");
        }
    }
}
