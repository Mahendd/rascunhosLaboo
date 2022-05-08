package controllers;

import models.AuthToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import params.AuthorizeParams;
import services.SpotifyAuthorizationService;

@RestController
public class SpotifyApiController {

    @GetMapping
    AuthToken authorize(@RequestBody AuthorizeParams params){
        var AuthorizationService = new SpotifyAuthorizationService(params);
        var response =  AuthorizationService.call();
        return response ;
    }
}
