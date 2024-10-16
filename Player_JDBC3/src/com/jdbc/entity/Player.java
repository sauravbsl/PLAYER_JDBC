package com.jdbc.entity;

import java.util.List;

public class Player {
	private String name;
	private int jersyNo;
	private int matches_Played;
	private int debut_Date;
	private String type;
	private int runs;
	private int wickets;
	public Player(String name, int jersyNo, int matches_Played, int debut_Date, String type, int runs, int wickets) {
		super();
		this.name = name;
		this.jersyNo = jersyNo;
		this.matches_Played = matches_Played;
		this.debut_Date = debut_Date;
		this.type = type;
		this.runs = runs;
		this.wickets = wickets;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJersyNo() {
		return jersyNo;
	}
	public void setJersyNo(int jersyNo) {
		this.jersyNo = jersyNo;
	}
	public int getMatches_Played() {
		return matches_Played;
	}
	public void setMatches_Played(int matches_Played) {
		this.matches_Played = matches_Played;
	}
	public int getDebut_Date() {
		return debut_Date;
	}
	public void setDebut_Date(int debut_Date) {
		this.debut_Date = debut_Date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", jersyNo=" + jersyNo + ", matches_Played=" + matches_Played + ", debut_Date="
				+ debut_Date + ", type=" + type + ", runs=" + runs + ", wickets=" + wickets + "]";
	}
	}