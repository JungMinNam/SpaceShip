package com.spaceship.board.domain;

import java.util.Date;

public class BoardVO {
	private Integer bidx;
	private String btitle;
	private String uid;
	private Date credate;
	
	public Integer getBidx() {
		return bidx;
	}
	public void setBidx(Integer bidx) {
		this.bidx = bidx;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Date getCredate() {
		return credate;
	}
	public void setCredate(Date credate) {
		this.credate = credate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bidx=" + bidx + ", btitle=" + btitle + ", uid=" + uid + ", credate=" + credate + "]";
	}
}
