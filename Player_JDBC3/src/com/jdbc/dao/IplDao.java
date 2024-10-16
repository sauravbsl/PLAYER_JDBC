package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.entity.Player;
import com.utility.DBConnectionUtil;

public class IplDao {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/players";
	String Username = "root";
	String Password = "root";
	String show_all = "SELECT * FROM players.playertable";
	static String insert = "INSERT INTO players.playertable (name, jersyNo, matches_Played, debut_Date, type, runs, wickets) VALUES (?, ?, ?, ?, ?, ?, ?)";
	static String update = "UPDATE players.playertable SET jersyNo = ?, matches_Played = ?, debut_Date = ?, type = ?, runs = ?, wickets = ? WHERE name = ?";
	static String remove = "DELETE FROM players.playertable where name=?";
	List<Player> allPlayerList = new ArrayList();

	public List<Player> getallplayer() {

		try {
			Class.forName(path);
			Connection con = DriverManager.getConnection(url, Username, Password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(show_all);
			while (rs.next()) {
				String name = rs.getString("name");
				int jersyNo = rs.getInt("jersyNo");
				int matches_Played = rs.getInt("matches_Played");
				int debut_Date = rs.getInt("debut_Date");
				String type = rs.getString("type");
				int runs = rs.getInt("runs");
				int wickets = rs.getInt("wickets");

				System.out.printf("|%-15s|%-4d|%-10d|%-10d|%-15s|%-6d|%-6d\n", name, jersyNo, matches_Played,
						debut_Date, type, runs, wickets);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return allPlayerList;
	}

	public static String addPlayer(Player player) {
		String declaration = null;

		try {
			Connection con = DBConnectionUtil.getConnection();
			PreparedStatement st1 = con.prepareStatement(insert);

			st1.setString(1, player.getName());
			st1.setInt(2, player.getJersyNo());
			st1.setInt(3, player.getMatches_Played());
			st1.setInt(4, player.getDebut_Date());
			st1.setString(5, player.getType());
			st1.setInt(6, player.getRuns());
			st1.setInt(7, player.getWickets());
			int rowAffected = st1.executeUpdate();
			if (rowAffected > 0) {
				declaration = "Insertion Succesfully ";
			} else {
				declaration = "Insertion Invalid ";
			}

		} catch (Exception e) {

		}
		return declaration;
	}

	public static String updatePlayer(Player player) {
	    String updateDeclaration = null;

	    try {
	        Connection con = DBConnectionUtil.getConnection();
	        PreparedStatement st1 = con.prepareStatement(update);

	        // Set the new values to update
	        st1.setInt(1, player.getJersyNo());
	        st1.setInt(2, player.getMatches_Played());
	        st1.setInt(3, player.getDebut_Date());
	        st1.setString(4, player.getType());
	        st1.setInt(5, player.getRuns());
	        st1.setInt(6, player.getWickets());

	        // Specify the player name to update
	        st1.setString(7, player.getName());

	        int rowAffected = st1.executeUpdate();
	        if (rowAffected > 0) {
	            updateDeclaration = "Player updated successfully.";
	        } else {
	            updateDeclaration = "Player update failed. Check if the player exists.";
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return updateDeclaration;
	}

	public static String removePlayer(String name) {
		String removedeclaration = null;

		try {
			Connection con = DBConnectionUtil.getConnection();
			PreparedStatement st1 = con.prepareStatement(remove);
			st1.setString(1, name);
			int rowAffected = st1.executeUpdate();
			if (rowAffected > 0) {
				removedeclaration = "Player Removed Succesfully ";
			} else {
				removedeclaration = "Player Remove not Successfull...beacuse player not exist in our database";
			}

		} catch (Exception e) {

		}
		return removedeclaration;
	}
}