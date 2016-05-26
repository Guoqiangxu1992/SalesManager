package com.xu.manager.bean;

public class Data {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public int id;
	public Data(int id, long money, String name) {
		super();
		this.id = id;
		this.money = money;
		this.name = name;
	}
	public long money;
	public String name;
	
	public Data() {
		
	}
	

}
