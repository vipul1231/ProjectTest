package com.src;

import java.util.Date;

public class Chip {
	
	private Meta meta = null;
    public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public String getChipId() {
		return chipId;
	}
	public void setChipId(String chipId) {
		this.chipId = chipId;
	}
	public Integer getCurrency() {
		return currency;
	}
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public Integer getChipsetId() {
		return chipsetId;
	}
	public void setChipsetId(Integer chipsetId) {
		this.chipsetId = chipsetId;
	}
	public Integer getWheelChipsetId() {
		return wheelChipsetId;
	}
	public void setWheelChipsetId(Integer wheelChipsetId) {
		this.wheelChipsetId = wheelChipsetId;
	}
	public Integer getColorCode() {
		return colorCode;
	}
	public void setColorCode(Integer colorCode) {
		this.colorCode = colorCode;
	}
	public Integer getGamingIdCode() {
		return gamingIdCode;
	}
	public void setGamingIdCode(Integer gamingIdCode) {
		this.gamingIdCode = gamingIdCode;
	}
	public Integer getCasinoSiteIdCode() {
		return casinoSiteIdCode;
	}
	public void setCasinoSiteIdCode(Integer casinoSiteIdCode) {
		this.casinoSiteIdCode = casinoSiteIdCode;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public Boolean getAutoEnrolled() {
		return autoEnrolled;
	}
	public void setAutoEnrolled(Boolean autoEnrolled) {
		this.autoEnrolled = autoEnrolled;
	}
	public ChipOwnerType getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(ChipOwnerType ownerType) {
		this.ownerType = ownerType;
	}
	public Integer getPlayerOwnerId() {
		return playerOwnerId;
	}
	public void setPlayerOwnerId(Integer playerOwnerId) {
		this.playerOwnerId = playerOwnerId;
	}
	public String getCasinoOwnerId() {
		return casinoOwnerId;
	}
	public void setCasinoOwnerId(String casinoOwnerId) {
		this.casinoOwnerId = casinoOwnerId;
	}
	public Integer getToplogyNodeId() {
		return toplogyNodeId;
	}
	public void setToplogyNodeId(Integer toplogyNodeId) {
		this.toplogyNodeId = toplogyNodeId;
	}
	public Integer getBankrollId() {
		return bankrollId;
	}
	public void setBankrollId(Integer bankrollId) {
		this.bankrollId = bankrollId;
	}
	public Date getCreatedDtm() {
		return createdDtm;
	}
	public void setCreatedDtm(Date createdDtm) {
		this.createdDtm = createdDtm;
	}
	public Date getUpdatedDtm() {
		return updatedDtm;
	}
	public void setUpdatedDtm(Date updatedDtm) {
		this.updatedDtm = updatedDtm;
	}
	public String getChipsetLabel() {
		return chipsetLabel;
	}
	public void setChipsetLabel(String chipsetLabel) {
		this.chipsetLabel = chipsetLabel;
	}
	public ChipTransactionType getLastTxnType() {
		return lastTxnType;
	}
	public void setLastTxnType(ChipTransactionType lastTxnType) {
		this.lastTxnType = lastTxnType;
	}
	public Date getLastTxnDtm() {
		return lastTxnDtm;
	}
	public void setLastTxnDtm(Date lastTxnDtm) {
		this.lastTxnDtm = lastTxnDtm;
	}
	public Boolean getIncompleteData() {
		return incompleteData;
	}
	public void setIncompleteData(Boolean incompleteData) {
		this.incompleteData = incompleteData;
	}
	private String chipId = null;
    private Integer currency = null;
    private String denomination = null;
    private Integer chipsetId = null;
    private Integer wheelChipsetId = null;
    private Integer colorCode = null;
    private Integer gamingIdCode = null;
    private Integer casinoSiteIdCode = null;
    private Boolean valid = null;
    private Boolean autoEnrolled = null;
    private ChipOwnerType ownerType = null;
    private Integer playerOwnerId = null;
    private String casinoOwnerId = null;
    private Integer toplogyNodeId = null;
    private Integer bankrollId = null;
    private Date createdDtm = null;
    private Date updatedDtm = null;
    private String chipsetLabel = null;
    private ChipTransactionType lastTxnType = null;
    private Date lastTxnDtm = null;
    private Boolean incompleteData = null;

}
