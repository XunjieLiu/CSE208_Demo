package org.user.entity;

import java.util.HashMap;
import java.util.Map;

public class Student {
	private int sno;
	private String sname;
	private String spwd;
	private int sidentity = 0;
	private String suniv;
	private int syear = 0;
	private String smajor;
	private String smodule;
	private String semail;
	private Map<String, String> questions;
	private int sgender  =0;

	public Student(String sname, int sidentity, int syear, String smajor, String semail) {
		super();
		this.sname = sname;
		this.sidentity = sidentity;
		this.syear = syear;
		this.smajor = smajor;
		this.semail = semail;
	}

	public Student(String sname, String spwd) {
		super();
		this.sname = sname;
		this.spwd = spwd;
		this.questions = new HashMap<String, String>();
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", spwd=" + spwd + ", sidentity=" + sidentity + ", suniv="
				+ suniv + ", syear=" + syear + ", smajor=" + smajor + ", smodule=" + smodule + ", semail=" + semail
				+ ", questions=" + questions + ", sgender=" + sgender + "]";
	}

	public Student(String sname, String spwd, int sidentity, String suniv, int syear, String smajor, String smodule,
			String semail, Map<String, String> questions, int sgender) {
		super();
		this.sname = sname;
		this.spwd = spwd;
		this.sidentity = sidentity;
		this.suniv = suniv;
		this.syear = syear;
		this.smajor = smajor;
		this.smodule = smodule;
		this.semail = semail;
		this.questions = questions;
		this.sgender = sgender;
	}

	public Student(int sno, String sname, String spwd, int sidentity, String suniv, int syear, String smajor,
			String smodule, String semail, Map<String, String> questions, int sgender) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.spwd = spwd;
		this.sidentity = sidentity;
		this.suniv = suniv;
		this.syear = syear;
		this.smajor = smajor;
		this.smodule = smodule;
		this.semail = semail;
		this.questions = questions;
		this.sgender = sgender;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	public int getSidentity() {
		return sidentity;
	}

	public void setSidentity(int sidentity) {
		this.sidentity = sidentity;
	}

	public String getSuniv() {
		return suniv;
	}

	public void setSuniv(String suniv) {
		this.suniv = suniv;
	}

	public int getSyear() {
		return syear;
	}

	public void setSyear(int syear) {
		this.syear = syear;
	}

	public String getSmajor() {
		return smajor;
	}

	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}

	public String getSmodule() {
		return smodule;
	}

	public void setSmodule(String smodule) {
		this.smodule = smodule;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public Map<String, String> getQuestions() {
		return questions;
	}

	public void setQuestions(Map<String, String> questions) {
		this.questions = questions;
	}

	public int getSgender() {
		return sgender;
	}

	public void setSgender(int sgender) {
		this.sgender = sgender;
	}

}
