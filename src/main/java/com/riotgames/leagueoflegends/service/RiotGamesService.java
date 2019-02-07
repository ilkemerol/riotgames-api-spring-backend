package com.riotgames.leagueoflegends.service;

import com.riotgames.leagueoflegends.models.SummonerModel;

public interface RiotGamesService {

	public SummonerModel getSummonerByName(String summonerName, String server);
	public String getSummonerByNameFE(String summonerName, String server);
	
	public String getSummonerActiveGame(String summonerName, String server);
}
