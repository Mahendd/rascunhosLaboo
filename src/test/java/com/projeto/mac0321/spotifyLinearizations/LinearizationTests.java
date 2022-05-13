package com.projeto.mac0321.spotifyLinearizations;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.projeto.mac0321.SpotifyPlaylistService.SpotifyPlaylistService;
import com.projeto.mac0321.SpotifySearchService.SpotifySearchService;
import com.projeto.mac0321.SpotifyUserService.SpotifyUserService;
import se.michaelthelin.spotify.enums.ModelObjectType;
import se.michaelthelin.spotify.model_objects.special.SearchResult;
import se.michaelthelin.spotify.model_objects.special.SnapshotResult;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.model_objects.specification.PlaylistSimplified;
import se.michaelthelin.spotify.model_objects.specification.User;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class LinearizationTests {
    public static void main(String[] args) throws URISyntaxException {
        User getCurrentUserReturn;
        Playlist createPlaylistReturn;
        Playlist getPlaylistReturn;
        String removePlaylistReturn;
        Paging<PlaylistSimplified> listPlaylistsReturn;
        SnapshotResult insertItemsReturn;
        SnapshotResult removeItemsReturn;
        SearchResult searchItemReturn;
        ArrayList<String> outputs = new ArrayList<>();
        Gson gson = new Gson();

        URI redirectURI = new URI("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert client id: ");
        String clientId = scanner.nextLine();
        System.out.println("Insert client secret: ");
        String clientSecret = scanner.nextLine();

        SpotifySearchService searcher = new SpotifySearchService(clientId, clientSecret, redirectURI);
        SpotifyPlaylistService playlistManager = new SpotifyPlaylistService(clientId, clientSecret, redirectURI);
        SpotifyUserService userManager = new SpotifyUserService(clientId, clientSecret, redirectURI);

        System.out.println("Insert token for user profiling:");
        userManager.setAccessToken(scanner.nextLine());
        getCurrentUserReturn = userManager.getCurrentUser();

        System.out.println("Insert token for playlist creation:");
        playlistManager.setAccessToken(scanner.nextLine());
        createPlaylistReturn = playlistManager.createPlaylist(getCurrentUserReturn.getId(), "Playlist linearizada");

        System.out.println("Insert token for playlist listing:");
        playlistManager.setAccessToken(scanner.nextLine());
        listPlaylistsReturn = playlistManager.listPlaylists(getCurrentUserReturn.getId());

        System.out.println("Insert token to get playlist:");
        playlistManager.setAccessToken(scanner.nextLine());
        getPlaylistReturn = playlistManager.getPlaylist(listPlaylistsReturn.getItems()[1].getId());

        System.out.println("Insert token for item searching:");
        searcher.setAccessToken(scanner.nextLine());
        searchItemReturn = searcher.searchItem("what a wonderful", ModelObjectType.TRACK.getType());

        System.out.println("Insert token for item insertion:");
        playlistManager.setAccessToken(scanner.nextLine());
        insertItemsReturn = playlistManager.insertItems(new String[]{"spotify:track:01iyCAUm8EvOFqVWYJ3dVX"}, createPlaylistReturn.getId());

        System.out.println("Insert token for item removal:");
        playlistManager.setAccessToken(scanner.nextLine());
        removeItemsReturn = playlistManager.removeItems(JsonParser.parseString("[{\"uri\":\"spotify:track:01iyCAUm8EvOFqVWYJ3dVX\"}]").getAsJsonArray(), createPlaylistReturn.getId());

        System.out.println("Insert token for playlist removal:");
        playlistManager.setAccessToken(scanner.nextLine());
        removePlaylistReturn = playlistManager.removePlaylist(getCurrentUserReturn.getId(), createPlaylistReturn.getId());

        outputs.add(gson.toJson(getCurrentUserReturn));
        outputs.add(gson.toJson(createPlaylistReturn));
        outputs.add(gson.toJson(getPlaylistReturn));
        outputs.add(gson.toJson(removePlaylistReturn));
        outputs.add(gson.toJson(listPlaylistsReturn));
        outputs.add(gson.toJson(insertItemsReturn));
        outputs.add(gson.toJson(removeItemsReturn));
        outputs.add(gson.toJson(searchItemReturn));

        System.out.println("Outputs:");
        for (String e : outputs) {
            System.out.println(e);
        }
    }
}
