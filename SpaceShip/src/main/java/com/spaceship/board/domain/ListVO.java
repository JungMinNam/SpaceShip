package com.spaceship.board.domain;

import java.util.Date;

public class ListVO {
	private int lidx;
	private int bidx;
	private String ltitle;
	private Date credate;
	
	public int getLidx() {
		return lidx;
	}
	public void setLidx(int lidx) {
		this.lidx = lidx;
	}
	public int getBidx() {
		return bidx;
	}
	public void setBidx(int bidx) {
		this.bidx = bidx;
	}
	public String getLtitle() {
		return ltitle;
	}
	public void setLtitle(String ltitle) {
		this.ltitle = ltitle;
	}
	public Date getCredate() {
		return credate;
	}
	public void setCredate(Date credate) {
		this.credate = credate;
	}
	
	@Override
	public String toString() {
		return "ListVO [lidx=" + lidx + ", bidx=" + bidx + ", ltitle=" + ltitle + ", credate=" + credate + "]";
	}
}
