package com.jdbc.service;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.IplDao;
import com.jdbc.entity.Player;

public class IplService {
	IplDao Dao = null;
	List<Player> allPlayerList = new ArrayList();

	public List<Player> getallplayer() {
		
		Dao = new IplDao();
		allPlayerList = Dao.getallplayer();
		return allPlayerList;
	}

	public String addPlayer(Player player) {
		Dao = new IplDao();
		return Dao.addPlayer(player);

	}
	public String updatePlayer(Player player) {
		Dao = new IplDao();
		return Dao.updatePlayer(player);

	}
	public String removePlayer(String name) {
		Dao = new IplDao();
		return Dao.removePlayer(name);

	}
}