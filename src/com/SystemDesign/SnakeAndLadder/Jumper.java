package com.SystemDesign.SnakeAndLadder;

import java.util.Objects;

public class Jumper {
	int startPoint;
	int endPoint;

	public Jumper(int startPoint, int endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public int getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endPoint, startPoint);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jumper other = (Jumper) obj;
		return endPoint == other.endPoint && startPoint == other.startPoint;
	}

}
