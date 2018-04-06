package com.src;

import java.util.Date;

public class PlayerStatsUpdate {
	
	private String gameUuid = null;
    public String getGameUuid() {
		return gameUuid;
	}

	public void setGameUuid(String gameUuid) {
		this.gameUuid = gameUuid;
	}

	public Integer getTopologyId() {
		return topologyId;
	}

	public void setTopologyId(Integer topologyId) {
		this.topologyId = topologyId;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Double getPlayerWin() {
		return playerWin;
	}

	public void setPlayerWin(Double playerWin) {
		this.playerWin = playerWin;
	}

	public Double getCasinoWin() {
		return casinoWin;
	}

	public void setCasinoWin(Double casinoWin) {
		this.casinoWin = casinoWin;
	}

	public Double getTurnover() {
		return turnover;
	}

	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}

	public Integer getBetCount() {
		return betCount;
	}

	public void setBetCount(Integer betCount) {
		this.betCount = betCount;
	}

	public Date getLastPayoutDtm() {
		return lastPayoutDtm;
	}

	public void setLastPayoutDtm(Date lastPayoutDtm) {
		this.lastPayoutDtm = lastPayoutDtm;
	}

	public Date getGamingDay() {
		return gamingDay;
	}

	public void setGamingDay(Date gamingDay) {
		this.gamingDay = gamingDay;
	}

	public Long getPlayTimeMillis() {
		return playTimeMillis;
	}

	public void setPlayTimeMillis(Long playTimeMillis) {
		this.playTimeMillis = playTimeMillis;
	}

	public Double getSwipedTheoWin() {
		return swipedTheoWin;
	}

	public void setSwipedTheoWin(Double swipedTheoWin) {
		this.swipedTheoWin = swipedTheoWin;
	}

	public Double getKnownTheoWin() {
		return knownTheoWin;
	}

	public void setKnownTheoWin(Double knownTheoWin) {
		this.knownTheoWin = knownTheoWin;
	}

	public Double getAnonymousTheoWin() {
		return anonymousTheoWin;
	}

	public void setAnonymousTheoWin(Double anonymousTheoWin) {
		this.anonymousTheoWin = anonymousTheoWin;
	}

	public Double getSwipedTurnover() {
		return swipedTurnover;
	}

	public void setSwipedTurnover(Double swipedTurnover) {
		this.swipedTurnover = swipedTurnover;
	}

	public Double getKnownTurnover() {
		return knownTurnover;
	}

	public void setKnownTurnover(Double knownTurnover) {
		this.knownTurnover = knownTurnover;
	}

	public Double getAnonymousTurnover() {
		return anonymousTurnover;
	}

	public void setAnonymousTurnover(Double anonymousTurnover) {
		this.anonymousTurnover = anonymousTurnover;
	}

	private Integer topologyId = null;
    private Integer playerId = null;
    private Double playerWin = null;
    private Double casinoWin = null;
    private Double turnover = null;
    private Integer betCount = null;
    private Date lastPayoutDtm = null;
    private Date gamingDay = null;
    private Long playTimeMillis = null;
    private Double swipedTheoWin = null;
    private Double knownTheoWin = null;
    private Double anonymousTheoWin = null;
    private Double swipedTurnover = null;
    private Double knownTurnover = null;
    private Double anonymousTurnover = null;

    public PlayerStatsUpdate() {
    }
	
}
