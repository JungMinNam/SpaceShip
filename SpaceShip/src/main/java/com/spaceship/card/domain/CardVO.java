package com.spaceship.card.domain;

import java.util.Arrays;
import java.util.Date;

public class CardVO {
	
	private int cidx;
	private int bidx;
	private int lidx;
	private String ctitle;
	private String content;
	private int grade;
	private String uid;
	private Date credate;
	private Date deadline;
	private String ltitle;
	private String[] files;
	private String attachname;
	private String originalname;
	
	public int getCidx() {
		return cidx;
	}
	public void setCidx(int cidx) {
		this.cidx = cidx;
	}
	public int getBidx() {
		return bidx;
	}
	public void setBidx(int bidx) {
		this.bidx = bidx;
	}
	public int getLidx() {
		return lidx;
	}
	public void setLidx(int lidx) {
		this.lidx = lidx;
	}
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
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
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getLtitle() {
		return ltitle;
	}
	public void setLtitle(String ltitle) {
		this.ltitle = ltitle;
	}
	
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	
	public String getAttachname() {
		return attachname;
	}
	public void setAttachname(String attachname) {
		this.attachname = attachname;
	}
	
	public String getOriginalname() {
		return originalname;
	}
	public void setOriginalname(String originalname) {
		this.originalname = originalname;
	}
	
	@Override
	public String toString() {
		return "CardVO [cidx=" + cidx + ", bidx=" + bidx + ", lidx=" + lidx + ", ctitle=" + ctitle + ", content="
				+ content + ", grade=" + grade + ", uid=" + uid + ", credate=" + credate + ", deadline=" + deadline
				+ ", ltitle=" + ltitle + ", files=" + Arrays.toString(files) + ", attachname=" + attachname
				+ ", originalname=" + originalname + "]";
	}
	
}