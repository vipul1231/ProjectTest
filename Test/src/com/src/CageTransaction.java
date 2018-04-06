package com.src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CageTransaction {
	private Meta meta = null;
	  public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public TypeEnum getType() {
		return type;
	}
	public void setType(TypeEnum type) {
		this.type = type;
	}
	public ActionEnum getAction() {
		return action;
	}
	public void setAction(ActionEnum action) {
		this.action = action;
	}
	public Date getStartDtm() {
		return startDtm;
	}
	public void setStartDtm(Date startDtm) {
		this.startDtm = startDtm;
	}
	public Date getEndDtm() {
		return endDtm;
	}
	public void setEndDtm(Date endDtm) {
		this.endDtm = endDtm;
	}
	public Date getSubmitDtm() {
		return submitDtm;
	}
	public void setSubmitDtm(Date submitDtm) {
		this.submitDtm = submitDtm;
	}
	public Date getCompleteDtm() {
		return completeDtm;
	}
	public void setCompleteDtm(Date completeDtm) {
		this.completeDtm = completeDtm;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCasinoPlayerId() {
		return casinoPlayerId;
	}
	public void setCasinoPlayerId(String casinoPlayerId) {
		this.casinoPlayerId = casinoPlayerId;
	}
	public Integer getTopologyNodeId() {
		return topologyNodeId;
	}
	public void setTopologyNodeId(Integer topologyNodeId) {
		this.topologyNodeId = topologyNodeId;
	}
	public List<Chip> getChipsIn() {
		return chipsIn;
	}
	public void setChipsIn(List<Chip> chipsIn) {
		this.chipsIn = chipsIn;
	}
	public List<Chip> getChipsOut() {
		return chipsOut;
	}
	public void setChipsOut(List<Chip> chipsOut) {
		this.chipsOut = chipsOut;
	}
	public Double getTxnValue() {
		return txnValue;
	}
	public void setTxnValue(Double txnValue) {
		this.txnValue = txnValue;
	}
	public Integer getDealerId() {
		return dealerId;
	}
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}
	public Integer getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(Integer supervisorId) {
		this.supervisorId = supervisorId;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public Integer getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public PlayerType getPlayerType() {
		return playerType;
	}
	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}
	private Integer id = null;
	  private String uuid = null;
	  public enum TypeEnum {
	     AUTO_ENROLL,  ENROLL,  UPDATE_OWNER,  BUYIN,  CASHOUT,  CHANGE,  FILL,  CREDIT, 
	  };
	  private TypeEnum type = null;
	  public enum ActionEnum {
	     SUBMIT,  CANCEL, 
	  };
	  private ActionEnum action = null;
	  private Date startDtm = null;
	  private Date endDtm = null;
	  private Date submitDtm = null;
	  private Date completeDtm = null;
	  public enum StatusEnum {
	     SUBMITTED,  COMPLETED,  CANCELED, 
	  };
	  private StatusEnum status = null;
	  private Integer userId = null;
	  private String userName = null;
	  private String casinoPlayerId = null;
	  private Integer topologyNodeId = null;
	  private List<Chip> chipsIn = new ArrayList<Chip>();
	  private List<Chip> chipsOut = new ArrayList<Chip>();
	  private Double txnValue = null;
	  private Integer dealerId = null;
	  private Integer supervisorId = null;
	  private String dealerName = null;
	  private String supervisorName = null;
	  private Integer playerId = null;
	  private String playerName = null;
	  private PlayerType playerType = null;

}
