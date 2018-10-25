package com.java.designpatterns.factory;

public abstract class Computer {

	public abstract String getRAM();

	public abstract String getHDD();

	public abstract String getCPU();

	@Override
	public String toString() {
		return "Compute [RAM()=" + getRAM() + ", HDD()=" + getHDD() + ", CPU()=" + getCPU() + "]";
	}

}
