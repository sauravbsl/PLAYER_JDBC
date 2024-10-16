package com.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.IplDao;
import com.jdbc.entity.Player;
import com.jdbc.service.IplService;

public class IplController {
	IplService service = null;
	List<Player> allPlayerList = new ArrayList();

	public List<Player> getallplayer() {
		service = new IplService();
		allPlayerList = service.getallplayer();
		return allPlayerList;
	}

	public String addPlayer(Player player) {
		service = new IplService();
		return service.addPlayer(player);

	}

	public String updatePlayer(Player player) {
		service = new IplService();
		return service.updatePlayer(player);
	}
	public String removePlayer(String name) {
		service = new IplService();
		return service.removePlayer(name);
	}
}