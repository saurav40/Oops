package com.SystemDesign.SnakeAndLadder;

import java.util.Objects;

public class Player {
	private String playerName;
	private int id;
    
	public Player(String playerName, int id) {
		super();
		this.playerName = playerName;
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, playerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return id == other.id && Objects.equals(playerName, other.playerName);
	}

}
