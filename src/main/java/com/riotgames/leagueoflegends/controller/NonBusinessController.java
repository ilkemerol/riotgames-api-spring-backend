package com.riotgames.leagueoflegends.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riotgames.leagueoflegends.models.SummonerModel;
import com.riotgames.leagueoflegends.service.RiotGamesService;

@RestController
@RequestMapping(value = "/non-buss")
public class NonBusinessController {

	static final Logger logger = LoggerFactory.getLogger(NonBusinessController.class.getName());

	@Autowired
	private RiotGamesService riotGamesService;

	@GetMapping("/api-test")
	public String apiTest(@RequestParam(value = "summonerName") String summonerName, @RequestParam(value = "server") String server) {
		SummonerModel summonerModel = riotGamesService.getSummonerByName(summonerName, server);
		logger.info("###	SUMMONERMODEL	###");
		logger.info("profileIconId		{}", summonerModel.getProfileIconId());
		logger.info("name		{}", summonerModel.getName());
		logger.info("puuid		{}", summonerModel.getPuuid());
		logger.info("summonerLevel		{}", summonerModel.getSummonerLevel());
		logger.info("accountId		{}", summonerModel.getAccountId());
		logger.info("id		{}", summonerModel.getId());
		logger.info("revisionDate		{}", summonerModel.getRevisionDate());
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/summonerSearch")
	public String summonerSearch(@RequestParam(value = "summonerName") String summonerName, @RequestParam(value = "server") String server) {
		String data = riotGamesService.getSummonerByNameFE(summonerName, server);
		logger.info("###	DATA	###");
		logger.info("{}", data);
		return data;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/summonerActiveGame")
	public String summonerActiveGame(@RequestParam(value = "summonerName") String summonerName, @RequestParam(value = "server") String server) {
		String data = riotGamesService.getSummonerActiveGame(summonerName, server);
		logger.info("###	DATA	###");
		logger.info("{}", data);
		return data;
	}
}
