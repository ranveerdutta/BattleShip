package com.battleship.entity;

public class Block {

	private int x;
	
	private int y;
	
	//variable to hold the count of hit reqd to mark that block as dead
	private int hitCountReqd = 1;
	
	public Block(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	private int hitCount;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	
	public boolean redNumberOfHitsDone(){
		return this.hitCount >= this.hitCountReqd;
	}
	
	public boolean isBlockDead(int hitCountReqdForShipType){
		int reqdHitCountForDeadBlock = hitCountReqdForShipType > this.hitCountReqd ? hitCountReqdForShipType : this.hitCountReqd;
		if(this.getHitCount() >= reqdHitCountForDeadBlock){
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Block other = (Block) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public void increaseHitCount() {
		this.hitCount = this.hitCount + 1;
	}
	
	
}
