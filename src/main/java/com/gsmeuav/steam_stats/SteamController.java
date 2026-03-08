package com.gsmeuav.steam_stats;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SteamController {

    @Value("${STEAM_API_KEY}")
    private String apiKey;

    @GetMapping("/stats/ownedGames/{steamId}")
    public SteamResponse getStats(@PathVariable String steamId) {
        RestTemplate restTemplate = new RestTemplate();



        String url = "https://api.steampowered.com/IPlayerService/GetOwnedGames/v1/?key=" + apiKey  + "&steamid=" + steamId + "&include_appinfo=true&format=json";

        SteamResponse response = restTemplate.getForObject(url, SteamResponse.class);

        assert response != null;
        response.getResponse().getGames().sort((g1, g2) -> Integer.compare(g2.getPlayTimeMinutes(), g1.getPlayTimeMinutes()));

        return response;
    }
}