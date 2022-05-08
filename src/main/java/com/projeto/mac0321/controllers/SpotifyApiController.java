package com.projeto.mac0321.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.mac0321.params.AuthorizeParams;
import com.projeto.mac0321.SpotifyAuthorizationService.SpotifyAuthorizationService;
import se.michaelthelin.spotify.SpotifyApi;

@RestController
@RequestMapping("/authorize")
public class SpotifyApiController {

    @GetMapping
    public SpotifyApi authorize(){
        SpotifyAuthorizationService spotifyAuthorizationService = new SpotifyAuthorizationService();
        SpotifyApi spotifyApi = spotifyAuthorizationService.call();
        return spotifyApi;
    }
}
