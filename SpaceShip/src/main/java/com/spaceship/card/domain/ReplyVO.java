package com.spaceship.card.domain;

import java.util.Date;

public class ReplyVO {

	private Integer ridx;
	private Integer cidx;
	private Integer bidx;
	private String rcontent;
	private String ruid;
	private Date credate;
	private String ctitle;
	
	public Integer getRidx() {
		return ridx;
	}
	public void setRidx(Integer ridx) {
		this.ridx = ridx;
	}
	public Integer getCidx() {
		return cidx;
	}
	public void setCidx(Integer cidx) {
		this.cidx = cidx;
	}
	public Integer getBidx() {
		return bidx;
	}
	public void setBidx(Integer bidx) {
		this.bidx = bidx;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRuid() {
		return ruid;
	}
	public void setRuid(String ruid) {
		this.ruid = ruid;
	}
	public Date getCredate() {
		return credate;
	}
	public void setCredate(Date credate) {
		this.credate = credate;
	}	
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [ridx=" + ridx + ", cidx=" + cidx + ", bidx=" + bidx + ", rcontent=" + rcontent + ", ruid="
				+ ruid + ", credate=" + credate + ", ctitle=" + ctitle + "]";
	}
	
}
