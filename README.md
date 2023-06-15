# Tic-Tac-Toe Game
This is a simple implementation of the Tic-Tac-Toe game in Java. The game allows two players to take turns and plays on a 3x3 grid.

## How to Play
1. The game starts by displaying an empty grid.
2. Player X is prompted to enter the row and column numbers for their move.
3. Player O is prompted to enter the row and column numbers for their move.
4. Players take turns entering their moves until a win, draw, or continue status is reached.
5. If a player wins, the game displays the winning player.
6. If the game ends in a draw, it displays a draw message.
7. The game continues until a win or draw occurs.
## Code Explanation
The code consists of two classes: Main and TicTacToe.

## Main Class
The Main class contains the main method, which is the entry point of the program. It creates an instance of the TicTacToe class and starts the game.

## TicTacToe Class
The TicTacToe class represents the Tic-Tac-Toe game. It has the following components:

- enum CellStates: Defines the possible states of a cell on the game board: X, O, or EMPTY.
- enum gameStatus: Defines the possible game status: WIN, DRAW, or CONTINUE.
- turn: Tracks the current player's turn.
- board: Represents the game board as a 2D array of CellStates.
getCellState(CellStates p): Converts a CellStates value to its corresponding character representation (X, O, or empty).
TicTacToe(String CellStateX, String CellStateO): Constructor that initializes the game board with empty cells.
PrintBoard(): Prints the current state of the game board.
ValidMove(int row, int column): Checks if a move is valid (within the board boundaries and the cell is empty).
getgameStatus(): Checks the game status by examining the board for wins, draws, or ongoing games.
startGame(): Starts the game loop, where players take turns entering their moves and checks for a win or draw.
Running the Game
To run the game, compile the Java file and execute the Main class. The program will prompt the players for their moves and display the game board until a win or draw occurs.

Enjoy playing Tic-Tac-Toe!





