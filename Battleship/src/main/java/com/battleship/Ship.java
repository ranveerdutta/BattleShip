package com.battleship.entity;

import java.util.ArrayList;
import java.util.List;

import com.battleship.enums.ShipType;
import com.battleship.exception.InvalidShipPositionException;

public class Ship {
	
	private int sizeInBlocks;
	
	private List<Block> occupiedBlocks;
	
	private ShipType shipType;
	
	
	public Ship(ShipType shipType, Block startBlock, Block endBlock){
		this.shipType = shipType;
		this.occupiedBlocks = new ArrayList<>();
		//Assuming start and end co-ordinate of the ships are given either left to right or bottom to top
		if(startBlock.getX() == endBlock.getX()){
			int x = startBlock.getX();
			int y = startBlock.getY();
			y++;
			occupiedBlocks.add(startBlock);
			while(y <= endBlock.getY()){
				occupiedBlocks.add(new Block(x, y++));
			}
			
		}
		else if(startBlock.getY() == endBlock.getY()){
			int x = startBlock.getX();
			int y = startBlock.getY();
			x++;
			occupiedBlocks.add(startBlock);
			while(x <= endBlock.getX()){
				occupiedBlocks.add(new Block(x++, y));
			}
			
		}else{
			throw new InvalidShipPositionException("Position of ship is not correct");
		}
	}

	public int getSizeInBlocks() {
		return sizeInBlocks;
	}

	public void setSizeInBlocks(int sizeInBlocks) {
		this.sizeInBlocks = sizeInBlocks;
	}

	public List<Block> getOccupiedBlocks() {
		return occupiedBlocks;
	}

	public void setOccupiedBlocks(List<Block> occupiedBlocks) {
		this.occupiedBlocks = occupiedBlocks;
	}

	public ShipType getShipType() {
		return shipType;
	}

	public void setShipType(ShipType shipType) {
		this.shipType = shipType;
	}
	
	public boolean isShipDead(){
		for(Block block : occupiedBlocks){
			if(!block.isBlockDead(this.shipType.getReqdHitCount())){
				return false;
			}
		}
		return true;
	}
	
	public boolean isShipDead(int numOfDeadBlocksRequired){
		int blocksDead = 0;
		for(Block block : occupiedBlocks){
			if(!block.isBlockDead(this.shipType.getReqdHitCount())){
				return false;
			}
			blocksDead++;
			
		}
		
		if(blocksDead >= numOfDeadBlocksRequired){
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean isHit(int x, int y){
		Block hitBlock = new Block(x, y);
		for(Block block : occupiedBlocks){
			if(block.equals(hitBlock)){
				block.increaseHitCount();
				if(block.getHitCount() > 1){
					continue;
				}else{
					return true;
				}
			}
		}
		return false;
	}
}
