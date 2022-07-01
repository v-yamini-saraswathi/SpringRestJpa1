package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
	@Id
	@GeneratedValue
	private int lid;
	private String lname;
	private String lcompany;
	
	@ManyToOne
	@JoinColumn(name="jid",referencedColumnName="cid")
	//@JsonBackReference
	
	Coder coder;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLcompany() {
		return lcompany;
	}
	public void setLcompany(String lcompany) {
		this.lcompany = lcompany;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + ", lcompany=" + lcompany + ", coder=" + coder + "]";
	}
	

}
