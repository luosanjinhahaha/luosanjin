package com.smxy.healthmedical.bean;

public class Media {
	private int mid;
	private String mname;
	private String mtime;
	private String mcontent;
	public Media() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Media(int mid, String mname, String mtime, String mcontent) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mtime = mtime;
		this.mcontent = mcontent;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	@Override
	public String toString() {
		return "Media [mid=" + mid + ", mname=" + mname + ", mtime=" + mtime
				+ ", mcontent=" + mcontent + "]";
	}
}
