package com.example.demo;

import org.springframework.stereotype.Component;

@Component("lap1")

public class Laptop {
	private int lid;
	private String version;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", version=" + version + "]";
	}
	public void compile() {
		System.out.println("compiling");
		
	}


}
