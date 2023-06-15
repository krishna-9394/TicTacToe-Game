import java.util.Scanner;
public class TicTacToe {
    
    enum CellStates {
        X,
        O,
        EMPTY,
    }
    private CellStates turn;
    private CellStates[][] board; //board as per requirement
    
    enum gameStatus {WIN, DRAW, CONTINUE}
    public char getCellState(CellStates p) {
        if (p == CellStates.X)
        return 'X';
        else if (p == CellStates.O)
            return 'O';
        else
        return ' ';
    }
    public TicTacToe(String CellStateX, String CellStateO) {
        board = new CellStates[3][3];
        for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
                board[i][j] = CellStates.EMPTY;
        }
    public void PrintBoard(){
         for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j <=3; j++) {
                if(j!=3) System.out.print("| "+getCellState(board[i][j])+" ");
                else System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("------------");
    }
    public boolean ValidMove(int row, int column) {
        return ((row >= 0 && row <= 3) && (column >= 0 && column <= 3) && (board[row][column] == CellStates.EMPTY)); 
    }
    public gameStatus getgameStatus() {
        for (int i = 0; i < 3; i++) //Run through each cell to check value for 3 in-a-row.
        {
            boolean similarity_in_row=true;
            boolean similarity_in_vertical=true;
            for(int j=1;j<3;j++)
            {
                if(board[i][j]!=board[i][0]) 
                {
                    similarity_in_row=false;
                    break;
                }
            }   
            if(similarity_in_row)
            {
                if (board[i][0] == CellStates.X) 
                    return gameStatus.WIN;
                    else if (board[i][0] == CellStates.O) 
                    return gameStatus.WIN;
                else
                return gameStatus.CONTINUE; 
            }
            for(int j=1;j<3;j++)
            {
                if(board[j][i]!=board[0][i]) 
                {
                    similarity_in_vertical=false;
                    break;
                }
            }   
            if(similarity_in_vertical)
            {
                if (board[0][i] == CellStates.X) 
                    return gameStatus.WIN;
                    else if (board[0][i] == CellStates.O) 
                    return gameStatus.WIN;
                else
                return gameStatus.CONTINUE; 
            }
        }
        //Run through diagonals to check
        if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) //If diagonal ( \ ) 3 in-a-row.
        {
            if (board[0][0] == CellStates.X) 
                return gameStatus.WIN;
            else if (board[0][0] == CellStates.O) 
            return gameStatus.WIN;
            else
            return gameStatus.CONTINUE; 
        }
        if ((board[2][0] == board[1][1]) && (board[1][1] == board[0][2])) //If diagonal ( / ) 3 in-a-row.
        {
            if (board[2][0] == CellStates.X) 
                return gameStatus.WIN;
            else if (board[2][0] == CellStates.O) 
                return gameStatus.WIN;
                else
                return gameStatus.CONTINUE; 
            }
        // To check weather all cells are filled or not
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if (board[i][j] == CellStates.EMPTY) {
                    return gameStatus.CONTINUE;
                }
            }
        }
        return gameStatus.DRAW;
    }
    public void startGame(){
        boolean x_turn=true;
        while(getgameStatus()==gameStatus.CONTINUE)
        {
            PrintBoard();
            int row_no,column_no;
            if(x_turn)
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Player X's turn."); 
                System.out.print("Player X: Enter row(0, 1 or 2):    "); 
                row_no=sc.nextInt();            
                System.out.print("Player X: Enter cplumn(0, 1 or 2): ");
                column_no=sc.nextInt(); 
                turn=CellStates.X;
            }
            else
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Player O's turn."); 
                System.out.print("Player O: Enter row(0, 1 or 2):    "); 
                row_no=sc.nextInt();            
                System.out.print("Player O: Enter cplumn(0, 1 or 2): ");
                column_no=sc.nextInt();
                turn=CellStates.O; 
            }
            if(ValidMove(row_no, column_no))
            {
                board[row_no][column_no]=turn;
                if(getgameStatus()==gameStatus.WIN)
                {
                    PrintBoard();
                    if(x_turn) System.out.println("Player X WINS.");
                    else System.out.println("Player O WINS.");
                }
                else if(getgameStatus()==gameStatus.DRAW)
                {
                    PrintBoard();
                    System.out.println("Draw Match.");
                }
                else
                {
                    if(x_turn) x_turn=false;
                    else x_turn=true;
                    continue;
                }
            }
            else
            {
                System.out.println("Enter the valid move..");
                continue;
            }
            if(x_turn) x_turn=false;
                    else x_turn=true;
        }   
    }
}