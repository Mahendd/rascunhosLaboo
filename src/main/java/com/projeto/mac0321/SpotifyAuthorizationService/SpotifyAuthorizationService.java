package com.projeto.mac0321.SpotifyAuthorizationService;

import com.projeto.mac0321.params.AuthorizeParams;
import se.michaelthelin.spotify.SpotifyApi;


public class SpotifyAuthorizationService {

    public SpotifyAuthorizationService() {

    }

    public SpotifyApi call() {
//        implement comunication with spotify api
        AuthorizationCodeUri authorizeCodeUri = new AuthorizationCodeUri();
        SpotifyApi spotifyApi = authorizeCodeUri.call();

        AuthorizationCode authorizationCode = new AuthorizationCode(spotifyApi);
        authorizationCode.call();

        return spotifyApi;
    }

}
