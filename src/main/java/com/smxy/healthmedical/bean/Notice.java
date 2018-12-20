package com.smxy.healthmedical.bean;

public class Notice {
	private int	nid;
	private String nname;
	private String ntime;
	private String ncontent;
	public Notice() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Notice(int nid, String nname, String ntime, String ncontent) {
		super();
		this.nid = nid;
		this.nname = nname;
		this.ntime = ntime;
		this.ncontent = ncontent;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public String getNtime() {
		return ntime;
	}
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	@Override
	public String toString() {
		return "Notice [nid=" + nid + ", nname=" + nname + ", ntime=" + ntime
				+ ", ncontent=" + ncontent + "]";
	}
}
