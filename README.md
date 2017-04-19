# BattleShip

Assumptions:
-------------
- the keyboard inputs will always be in correct format. The code does not verifies negative inputs
- the ship co-ordinates will always be given either from left to right or bottom to top. Not in opposite order
- all the given co-ordinates are always within the range of board size.

have not included the unit test case.
compiled and executed in Java 8.

The code can be imported as Eclipse project and can be executed by executing the file BattleshipGame.java

One of the test case is given below (input and output both given):
--------------------------------------------------------------------
Please enter board size:4
Please enter ship count:2
For player 1:
Please enter start and end co-ordanates for ship1:1 1 3 1
Please enter start and end co-ordanates for ship2:4 1 4 3
For player 2:
Please enter start and end co-ordanates for ship1:2 2 4 2
Please enter start and end co-ordanates for ship2:2 4 4 4
Player 1 guess a block :1 1
It was miss
Player 2 guess a block :1 1
It was hit
Player 1 guess a block :2 3
It was miss
Player 2 guess a block :1 1
It was miss
Player 1 guess a block :3 2
It was hit
Player 2 guess a block :1 1
It was miss
Player 1 guess a block :2 2
It was hit
Player 2 guess a block :1 1
It was miss
Player 1 guess a block :4 2
It was hit
Player 2 guess a block :1 1
It was miss
Player 1 guess a block :4 4
It was hit
Player 2 guess a block :1 1
It was miss
Player 1 guess a block :2 4
It was hit
Player 2 guess a block :1 1
It was miss
Player 1 guess a block :3 4
It was hit
Player 1 wins
------------------------------------------------------------------------------------------------------
