package com.battleship.enums;

public enum ShipType {
	
	NORMAL_SHIP(1),
	SUPER_SHIP(2);
	
	private int reqdHitCount;
	
	private ShipType(int count){
		reqdHitCount = count;
	}

	public int getReqdHitCount() {
		return reqdHitCount;
	}
	
}
