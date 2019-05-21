package org.user.entity;

public class File {
	private int mid;
	private String furl;
	private String fname;
	private String ftype;
	private String fdate;

	public File(String furl, String fname) {
		super();
		this.furl = furl;
		this.fname = fname;
	}

	public File(int mid, String furl, String fname, String ftype, String fdate) {
		super();
		this.mid = mid;
		this.furl = furl;
		this.fname = fname;
		this.ftype = ftype;
		this.fdate = fdate;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getFurl() {
		return furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

}
