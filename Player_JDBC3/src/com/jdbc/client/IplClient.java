package com.jdbc.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jdbc.controller.IplController;
import com.jdbc.entity.Player;

public class IplClient {
	static IplController control = null;
	static List<Player> allPlayerList = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("!!!Welcome to our System!!!");
		System.out.println("This is our menu");
		System.out.println("1. Show All Players");
		System.out.println("2. Insert New Player");
		System.out.println("3. Update Players From System");
		System.out.println("4. Remove Players Into System ");
		System.out.println("5. Exit");

		Scanner sc = new Scanner(System.in);
		control = new IplController();

		while (true) {
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				allPlayerList = control.getallplayer();
				for (Player player : allPlayerList) {
					System.out.println(player);
				}
				break;

			case 2:
				System.out.println("Enter Player Details:");
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Jersey No: ");
				int jersyNo = sc.nextInt();
				System.out.print("Matches Played: ");
				int matchesPlayed = sc.nextInt();
				System.out.print("Debut Date (Year): ");
				int debutDate = sc.nextInt();
				System.out.print("Type (Batsman/Bowler): ");
				String type = sc.next();
				System.out.print("Runs: ");
				int runs = sc.nextInt();
				System.out.print("Wickets: ");
				int wickets = sc.nextInt();

				Player newPlayer = new Player(name, jersyNo, matchesPlayed, debutDate, type, runs, wickets);
				String result = control.addPlayer(newPlayer);
				System.out.println(result);
				break;
			case 3:
				System.out.println("Enter Player Details:");
				System.out.print("Name: ");
				String uname = sc.next();
				System.out.print("Jersey No: ");
				int ujersyNo = sc.nextInt();
				System.out.print("Matches Played: ");
				int umatchesPlayed = sc.nextInt();
				System.out.print("Debut Date (Year): ");
				int udebutDate = sc.nextInt();
				System.out.print("Type (Batsman/Bowler): ");
				String utype = sc.next();
				System.out.print("Runs: ");
				int uruns = sc.nextInt();
				System.out.print("Wickets: ");
				int uwickets = sc.nextInt();

				Player newPlayerUpdate = new Player(uname,ujersyNo,umatchesPlayed,udebutDate,utype,uruns,uwickets);
				String resultupdate = control.updatePlayer(newPlayerUpdate);
				System.out.println(resultupdate);
				break;
			case 4:
				System.out.print("Name: ");
				String rname = sc.next();
				String resultremove = control.removePlayer(rname);
				System.out.println(resultremove);
				break;
			case 5:
				System.out.println("Exiting...Thank you visit again..!!!!");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
