package org.user.entity;

import java.util.Map;

public class Teacher {
	private int tno;
	private String tname;
	private String tpwd;
	private int tidentity;
	private String tuniversity;
	private String tmajor;
	private String temail;
	private Map<String, String> questions;
	
	public Teacher(int tno, String tname, String tpwd, int tidentity, String tuniversity, String tmajor, String temail,
			Map<String, String> questions) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.tpwd = tpwd;
		this.tidentity = tidentity;
		this.tuniversity = tuniversity;
		this.tmajor = tmajor;
		this.temail = temail;
		this.questions = questions;
	}
	public Teacher(String name, String pwd) {
		// TODO Auto-generated constructor stub
		this.tname= name;
		this.tpwd=pwd;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTpwd() {
		return tpwd;
	}
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}
	public int getTidentity() {
		return tidentity;
	}
	public void setTidentity(int tidentity) {
		this.tidentity = tidentity;
	}
	public String getTuniversity() {
		return tuniversity;
	}
	public void setTuniversity(String tuniversity) {
		this.tuniversity = tuniversity;
	}
	public String getTmajor() {
		return tmajor;
	}
	public void setTmajor(String tmajor) {
		this.tmajor = tmajor;
	}
	public String getTemail() {
		return temail;
	}
	public void setTemail(String temail) {
		this.temail = temail;
	}
	public Map<String, String> getQuestions() {
		return questions;
	}
	public void setQuestions(Map<String, String> questions) {
		this.questions = questions;
	}
	
}

