package com.riotgames.leagueoflegends.service;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.riotgames.leagueoflegends.models.SummonerModel;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

@Service
public class RiotGamesServiceImpl implements RiotGamesService {

	@Override
	public SummonerModel getSummonerByName(String summonerName, String server) {
		summonerName = summonerName.replaceAll("\\s", "%20");
		HttpResponse httpResponse = HttpRequest
				.get("https://" + server + ".api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName)
				.query("api_key", "RGAPI-95bbd10c-f2fc-4bb1-ae41-2e56b06672dc").send();

		Gson gson = new Gson();
		SummonerModel summonerModel = gson.fromJson(httpResponse.bodyText(), SummonerModel.class);
		return summonerModel;
	}

	@Override
	public String getSummonerByNameFE(String summonerName, String server) {
		summonerName = summonerName.replaceAll("\\s", "%20");
		HttpResponse httpResponse = HttpRequest
				.get("https://" + server + ".api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName)
				.query("api_key", "RGAPI-95bbd10c-f2fc-4bb1-ae41-2e56b06672dc").send();

		return httpResponse.bodyText();
	}

	@Override
	public String getSummonerActiveGame(String summonerName, String server) {
		SummonerModel summonerModel = getSummonerByName(summonerName, server);
		String encSummonerId = summonerModel.getId();
		
		if(encSummonerId != null) {
			HttpResponse httpResponse = HttpRequest
					.get("https://" + server + ".api.riotgames.com/lol/spectator/v4/active-games/by-summoner/" + encSummonerId)
					.query("api_key", "RGAPI-95bbd10c-f2fc-4bb1-ae41-2e56b06672dc").send();
			
			return httpResponse.bodyText();
		} else {
			return "{}";
		}
		
	}

}
