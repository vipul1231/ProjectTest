package com.src;

import java.util.Date;

public class ChipTrayScan {
	private Meta meta = null;
	  public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public Long getChipTrayScanId() {
		return chipTrayScanId;
	}
	public void setChipTrayScanId(Long chipTrayScanId) {
		this.chipTrayScanId = chipTrayScanId;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public String getScanUUID() {
		return scanUUID;
	}
	public void setScanUUID(String scanUUID) {
		this.scanUUID = scanUUID;
	}
	public ScanTypeEnum getScanType() {
		return scanType;
	}
	public void setScanType(ScanTypeEnum scanType) {
		this.scanType = scanType;
	}
	public Date getGamingDay() {
		return gamingDay;
	}
	public void setGamingDay(Date gamingDay) {
		this.gamingDay = gamingDay;
	}
	public Date getScanDtm() {
		return scanDtm;
	}
	public void setScanDtm(Date scanDtm) {
		this.scanDtm = scanDtm;
	}
	public Integer getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(Integer supervisorId) {
		this.supervisorId = supervisorId;
	}
	public String getSupervisorEmployeeCode() {
		return supervisorEmployeeCode;
	}
	public void setSupervisorEmployeeCode(String supervisorEmployeeCode) {
		this.supervisorEmployeeCode = supervisorEmployeeCode;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public String getSupervisorAuthToken() {
		return supervisorAuthToken;
	}
	public void setSupervisorAuthToken(String supervisorAuthToken) {
		this.supervisorAuthToken = supervisorAuthToken;
	}
	public Integer getDealerId() {
		return dealerId;
	}
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}
	public String getDealerEmployeeCode() {
		return dealerEmployeeCode;
	}
	public void setDealerEmployeeCode(String dealerEmployeeCode) {
		this.dealerEmployeeCode = dealerEmployeeCode;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getDealerAuthToken() {
		return dealerAuthToken;
	}
	public void setDealerAuthToken(String dealerAuthToken) {
		this.dealerAuthToken = dealerAuthToken;
	}
	public String getTopTrayChipIds() {
		return topTrayChipIds;
	}
	public void setTopTrayChipIds(String topTrayChipIds) {
		this.topTrayChipIds = topTrayChipIds;
	}
	public String getBottomTrayChipIds() {
		return bottomTrayChipIds;
	}
	public void setBottomTrayChipIds(String bottomTrayChipIds) {
		this.bottomTrayChipIds = bottomTrayChipIds;
	}
	public Double getTotalTrayValue() {
		return totalTrayValue;
	}
	public void setTotalTrayValue(Double totalTrayValue) {
		this.totalTrayValue = totalTrayValue;
	}
	public Double getTotalTxnValue() {
		return totalTxnValue;
	}
	public void setTotalTxnValue(Double totalTxnValue) {
		this.totalTxnValue = totalTxnValue;
	}
	public Double getVarianceAmount() {
		return varianceAmount;
	}
	public void setVarianceAmount(Double varianceAmount) {
		this.varianceAmount = varianceAmount;
	}
	public Double getCarryoverAmount() {
		return carryoverAmount;
	}
	public void setCarryoverAmount(Double carryoverAmount) {
		this.carryoverAmount = carryoverAmount;
	}
	public Double getActualDailyBalance() {
		return actualDailyBalance;
	}
	public void setActualDailyBalance(Double actualDailyBalance) {
		this.actualDailyBalance = actualDailyBalance;
	}
	public Double getExpectedDailyBalance() {
		return expectedDailyBalance;
	}
	public void setExpectedDailyBalance(Double expectedDailyBalance) {
		this.expectedDailyBalance = expectedDailyBalance;
	}
	public Double getTotalVarianceAmount() {
		return totalVarianceAmount;
	}
	public void setTotalVarianceAmount(Double totalVarianceAmount) {
		this.totalVarianceAmount = totalVarianceAmount;
	}
	public String getAdjustmentReasonCode() {
		return adjustmentReasonCode;
	}
	public void setAdjustmentReasonCode(String adjustmentReasonCode) {
		this.adjustmentReasonCode = adjustmentReasonCode;
	}
	public Double getBuyIn() {
		return buyIn;
	}
	public void setBuyIn(Double buyIn) {
		this.buyIn = buyIn;
	}
	public Double getRatedWinLoss() {
		return ratedWinLoss;
	}
	public void setRatedWinLoss(Double ratedWinLoss) {
		this.ratedWinLoss = ratedWinLoss;
	}
	public Double getUnratedWinLoss() {
		return unratedWinLoss;
	}
	public void setUnratedWinLoss(Double unratedWinLoss) {
		this.unratedWinLoss = unratedWinLoss;
	}
	private Long chipTrayScanId = 0l;
	  private Integer tableId = null;
	  private String scanUUID = null;
	  public enum ScanTypeEnum {
	     GAME,  OPENER,  CLOSER,  STARTING_FILL,  FILL,  CREDIT,  STARTING_CREDIT,  SCHEDULED,  MANUAL,  IDLE,  ADJUSTMENT,  BUYIN,  POWER_SCAN,  AUTO_SCAN, 
	  };
	  private ScanTypeEnum scanType = null;
	  private Date gamingDay = null;
	  private Date scanDtm = null;
	  private Integer supervisorId = null;
	  private String supervisorEmployeeCode = null;
	  private String supervisorName = null;
	  private String supervisorAuthToken = null;
	  private Integer dealerId = null;
	  private String dealerEmployeeCode = null;
	  private String dealerName = null;
	  private String dealerAuthToken = null;
	  private String topTrayChipIds = null;
	  private String bottomTrayChipIds = null;
	  private Double totalTrayValue = null;
	  private Double totalTxnValue = null;
	  private Double varianceAmount = null;
	  private Double carryoverAmount = null;
	  private Double actualDailyBalance = null;
	  private Double expectedDailyBalance = null;
	  private Double totalVarianceAmount = null;
	  private String adjustmentReasonCode = null;
	  private Double buyIn = null;
	  private Double ratedWinLoss = null;
	  private Double unratedWinLoss = null;
}
