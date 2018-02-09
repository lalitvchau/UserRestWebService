package com.lalit;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Users {
	private int id;
	private String name;
	private String addr;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ ID : "+this.id+", Name : "+this.name+", Addr : "+this.addr+" ]";
	}
}
