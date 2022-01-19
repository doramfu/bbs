package com.edu.vo;

public class NoticeVO {
	int ntcId;
	String ntcTitle;
	String ntcContent;
	String ntcDate;
	int ntcHit;
	
	public int getNtcId() {
		return ntcId;
	}
	public void setNtcId(int ntcId) {
		this.ntcId = ntcId;
	}
	public String getNtcTitle() {
		return ntcTitle;
	}
	public void setNtcTitle(String ntcTitle) {
		this.ntcTitle = ntcTitle;
	}
	public String getNtcContent() {
		return ntcContent;
	}
	public void setNtcContent(String ntcContent) {
		this.ntcContent = ntcContent;
	}
	public String getNtcDate() {
		return ntcDate;
	}
	public void setNtcDate(String ntcDate) {
		this.ntcDate = ntcDate;
	}
	public int getNtcHit() {
		return ntcHit;
	}
	public void setNtcHit(int ntcHit) {
		this.ntcHit = ntcHit;
	}
	@Override
	public String toString() {
		return "NoticeVO [ntcId=" + ntcId + ", ntcTitle=" + ntcTitle + ", ntcContent=" + ntcContent + ", ntcDate="
				+ ntcDate + ", ntcHit=" + ntcHit + "]";
	}
	
	
}
