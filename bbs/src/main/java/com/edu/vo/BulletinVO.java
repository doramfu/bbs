package com.edu.vo;

public class BulletinVO {
	private int bbsId;
	private String bbsTitle;
	private String bbsContent;
	private String bbsWriter;
	private String bbsImage;
	private String bbsCreateDate;
	private int bbsHit;
	
	public int getBbsId() {
		return bbsId;
	}
	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public String getBbsWriter() {
		return bbsWriter;
	}
	public void setBbsWriter(String bbsWriter) {
		this.bbsWriter = bbsWriter;
	}
	public String getBbsImage() {
		return bbsImage;
	}
	public void setBbsImage(String bbsImage) {
		this.bbsImage = bbsImage;
	}
	public String getBbsCreateDate() {
		return bbsCreateDate;
	}
	public void setBbsCreateDate(String bbsCreateDate) {
		this.bbsCreateDate = bbsCreateDate;
	}
	public int getBbsHit() {
		return bbsHit;
	}
	public void setBbsHit(int bbsHit) {
		this.bbsHit = bbsHit;
	}
	
	@Override
	public String toString() {
		return "BulletInVO [bbsId=" + bbsId + ", bbsTitle=" + bbsTitle + ", bbsContent=" + bbsContent + ", bbsWriter="
				+ bbsWriter + ", bbsImage=" + bbsImage + ", bbsCreateDate=" + bbsCreateDate + ", bbsHit=" + bbsHit
				+ "]";
	}
	
}
