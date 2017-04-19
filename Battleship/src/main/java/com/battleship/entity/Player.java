package com.battleship.entity;

import java.util.List;

public class Player {
	
	private static final int HIT_REQD_FOR_SUPER_USER = 1;
	private Board board;
	
	private List<Ship> ships;
	
	private boolean hasExtraPower = false;
	
	public Player(Board board) {
		super();
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}
	
	public boolean isHasExtraPower() {
		return hasExtraPower;
	}

	public void setHasExtraPower(boolean hasExtraPower) {
		this.hasExtraPower = hasExtraPower;
	}

	public boolean isPlayerDead(){
		for(Ship ship : ships){
			if(this.hasExtraPower){
				if(!ship.isShipDead(HIT_REQD_FOR_SUPER_USER)){
					return false;
				}
			}else{
				if(!ship.isShipDead()){
					return false;
				}
			}
			
		}
		return true;
	}
	
	public boolean isHit(int x, int y){
		for(Ship ship : ships){
			if(ship.isHit(x, y)){
				return true;
			}
		}
		return false;
	}
	
	

}
