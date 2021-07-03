package com.universities.ecuador.apirest.util;

public class PageItem {

	private int number;
	private boolean current;

	public PageItem(int number, boolean current) {
		this.current = current;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

}