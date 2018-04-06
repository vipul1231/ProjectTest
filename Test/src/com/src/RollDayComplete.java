package com.src;

import java.util.Date;

public class RollDayComplete {
	private String eventId = null;
	  public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public Date getToGamingDay() {
		return toGamingDay;
	}
	public void setToGamingDay(Date toGamingDay) {
		this.toGamingDay = toGamingDay;
	}
	public Date getAckDtm() {
		return ackDtm;
	}
	public void setAckDtm(Date ackDtm) {
		this.ackDtm = ackDtm;
	}
	public Date getCompleteDtm() {
		return completeDtm;
	}
	public void setCompleteDtm(Date completeDtm) {
		this.completeDtm = completeDtm;
	}
	public Integer getTopologyId() {
		return topologyId;
	}
	public void setTopologyId(Integer topologyId) {
		this.topologyId = topologyId;
	}
	public ChipTrayScan getOpenerChipTrayScan() {
		return openerChipTrayScan;
	}
	public void setOpenerChipTrayScan(ChipTrayScan openerChipTrayScan) {
		this.openerChipTrayScan = openerChipTrayScan;
	}
	public ChipTrayScan getCloserChipTrayScan() {
		return closerChipTrayScan;
	}
	public void setCloserChipTrayScan(ChipTrayScan closerChipTrayScan) {
		this.closerChipTrayScan = closerChipTrayScan;
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
	private Date toGamingDay = null;
	  private Date ackDtm = null;
	  private Date completeDtm = null;
	  private Integer topologyId = null;
	  private ChipTrayScan openerChipTrayScan = null;
	  private ChipTrayScan closerChipTrayScan = null;
	  private Integer dealerId = null;
	  private Integer supervisorId = null;

}
