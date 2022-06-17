import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String user1 = "Player X";
        String user2 = "Player O";
        TicTacToe game = new TicTacToe(user1, user2);
        game.startGame();
    }
}
