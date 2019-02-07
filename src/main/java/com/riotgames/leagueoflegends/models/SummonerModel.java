package com.riotgames.leagueoflegends.models;

public class SummonerModel {

	private Integer profileIconId;
	private String name;
	private String puuid;
	private Long summonerLevel;
	private Long revisionDate;
	private String id;
	private String accountId;

	public Integer getProfileIconId() {
		return profileIconId;
	}

	public void setProfileIconId(Integer profileIconId) {
		this.profileIconId = profileIconId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPuuid() {
		return puuid;
	}

	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}

	public Long getSummonerLevel() {
		return summonerLevel;
	}

	public void setSummonerLevel(Long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}

	public Long getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(Long revisionDate) {
		this.revisionDate = revisionDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

}
