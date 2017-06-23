package com.guszak.model;

public class Robot {

	private int x = 0;
	private int y = 0;
	private orientation currentOrientation = orientation.NORTH;
	private Boolean error = false;

	public enum orientation {
        NORTH, SOUTH, EAST, WEST
    };
	
	private int getX() {
		return x;
	}
	private int getY() {
		return y;
	}
	private void moveToNorth() {
		this.y++;
	}
	private void moveToSouth() {
		this.y--;
	}
	private void moveToEast() {
		this.x++;
	}
	private void moveToWest() {
		this.x--;
	}
	public Boolean getError() {
		return this.error;
	}
	private void setError(Boolean error) {
		this.error = error;
	}
	private orientation getOrientation() {
		return currentOrientation;
	}
	private void setOrientation(orientation currentOrientation) {
		this.currentOrientation = currentOrientation;
	}
	public String getPosition() {
		return "(" + this.getX() + ", " + this.getY() + ", " + this.getOrientation().name().charAt(0)+ ")";
	}
	public void executeMovements(String movements) {

		loop: for (char ch: movements.toCharArray()) {

			switch (ch) {

			// Rotate robot to the left side
			case 'L':
				switch (this.getOrientation()) {
				case NORTH: this.setOrientation(orientation.WEST); break;
				case SOUTH: this.setOrientation(orientation.EAST); break;
				case EAST: this.setOrientation(orientation.NORTH); break;
				case WEST: this.setOrientation(orientation.SOUTH); break;
				}
				break;

			// Rotate robot to the right side
			case 'R':
				switch (this.getOrientation()) {
				case NORTH: this.setOrientation(orientation.EAST); break;
				case SOUTH: this.setOrientation(orientation.WEST); break;
				case EAST: this.setOrientation(orientation.SOUTH); break;
				case WEST: this.setOrientation(orientation.NORTH); break;
				}
				break;

			// Move robot
			case 'M':
				switch (this.getOrientation()) {
				case NORTH: moveToNorth(); break;
				case SOUTH: moveToSouth(); break;
				case EAST: moveToEast(); break;
				case WEST: moveToWest(); break;
				}
				break;

			// Invalid command
			default:
				this.setError(true);
				break loop;
			}

			// Outside of area
			if(this.getX() < 0 || this.getY() < 0 || this.getX() > 4 || this.getY() > 4){
				this.setError(true);
				break loop;
			}
		}
	}
}
