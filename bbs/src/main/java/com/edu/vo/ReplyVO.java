package com.edu.vo;

public class ReplyVO {
	private int replyId;
	private String replyContent;
	private String replyWriter;
	private String replyDate;
	private int bbsId;
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	public int getBbsId() {
		return bbsId;
	}
	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}
	@Override
	public String toString() {
		return "ReplyVO [replyId=" + replyId + ", replyContent=" + replyContent + ", replyWriter=" + replyWriter
				+ ", replyDate=" + replyDate + ", bbsId=" + bbsId + "]";
	}
	
}
