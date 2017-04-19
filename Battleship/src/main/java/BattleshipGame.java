import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.battleship.entity.Block;
import com.battleship.entity.Board;
import com.battleship.entity.Player;
import com.battleship.entity.Ship;
import com.battleship.enums.ShipType;

public class BattleshipGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader r = new InputStreamReader(System.in);  
		BufferedReader br = new BufferedReader(r); 
		System.out.print("Please enter board size:");
		int boardSize = Integer.parseInt(br.readLine());
		
		Board board1 = new Board(boardSize, boardSize);
		Player player1 = new Player(board1);
		Board board2 = new Board(boardSize, boardSize);
		Player player2 = new Player(board2);
		
		System.out.print("Please enter ship count:");
		int shipCount = Integer.parseInt(br.readLine());
		
		System.out.println("For player 1:");
		List<Ship> ships = extractShipInfo(shipCount, br);
		player1.setShips(ships);

		System.out.println("For player 2:");
		ships = extractShipInfo(shipCount, br);
		player2.setShips(ships);
		
		startGame(br, player1, player2);
		
		br.close();
		
	}
	
	private static List<Ship> extractShipInfo(int shipCount, BufferedReader keyboard) throws IOException{
		List<Ship> ships = new ArrayList<>();
		for(int i =0; i<shipCount ; i++){
			System.out.print("Please enter start and end co-ordanates for ship" + (i+1) + ":");
			String positions = keyboard.readLine();
			String[] ordinates = positions.split(" ");
			int x1 = Integer.parseInt(ordinates[0]);
			int y1 = Integer.parseInt(ordinates[1]);
			int x2 = Integer.parseInt(ordinates[2]);
			int y2 = Integer.parseInt(ordinates[3]);
			Ship ship = new Ship(ShipType.NORMAL_SHIP, new Block(x1, y1), new Block(x2, y2));
			ships.add(ship);
		}
		return ships;
	}
	
	private static void startGame(BufferedReader keyboard, Player player1, Player player2) throws IOException{
		while(true){
			System.out.print("Player 1 guess a block :");
			boolean isGameOver = verifyPlayerGuess(keyboard, player2);
			if(isGameOver){
				System.out.println("Player 1 wins");
				return;
			}
			
			System.out.print("Player 2 guess a block :");
			isGameOver = verifyPlayerGuess(keyboard, player1);
			if(isGameOver){
				System.out.println("Player 2 wins");
				return;
			}
		}
		
	}
	
	private static boolean verifyPlayerGuess(BufferedReader keyboard, Player player) throws IOException{
		String position = keyboard.readLine();
		String[] ordinates = position.split(" ");
		boolean isHit = player.isHit(Integer.parseInt(ordinates[0]), Integer.parseInt(ordinates[1]));
		if(isHit){
			System.out.println("It was hit");
			return player.isPlayerDead();
		}
		System.out.println("It was miss");
		return false;
	}

}
