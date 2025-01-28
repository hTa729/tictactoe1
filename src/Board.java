
import java.util.*;

public class Board {
    public String [][] strArr = new String [3][3];
    public ArrayList moves;


    public Board () {

        moves = new ArrayList();

        for (int i = 0; i < 3; i++) {
            for ( int j =  0; j < 3; j++) {
                strArr[i][j] =  "-";
            }
        }

    }

    public void printBoard() {
        for (int i = 0; i <3; i++){
            System.out.print(strArr[i][0]+" "+strArr[i][1]+" "+strArr[i][2]+"\n");
        }
    }
    public Boolean winner() {
        for (int i = 0; i < 3; i++) {
            //check x win
            if (strArr[i][0] == "x" && strArr[i][1] == "x" && strArr[i][2] == "x") {
                Boolean winner = true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (strArr[0][j] == "x" && strArr[1][j] == "x" && strArr[2][j] == "x") {
                Boolean winner = true;
            }
        }
        for (int z = 0; z < 3; z++) {
            if (strArr[z][z] == "x" && strArr[z][z] == "x" && strArr[z][z] == "x") {
                Boolean winner = true;
            }

        }
        return null;
    }


    // board is the object of Board class - I think you want to change strArr the 2D Array attribute for the class
    public boolean makeMove(int row, int column, String symbol){
        if (strArr[row-1][column-1] == "-") {      // dion updated this section basically I was thinking we could return true and then continue to next round and if false do a while loop until they choose unoccupied coordinates
            strArr[row-1][column-1]= symbol;
            moves.add(Integer.toString(row-1));
            System.out.println(moves);
            System.out.println(moves.size());
            moves.add(Integer.toString(column-1));
            System.out.println(moves);
            return true;

        } else {
            return false; }

    }

    public String undo() {
        if (moves.isEmpty()) {
            return "Cannot undo move ";

        } else {
            int ans = moves.size();
            int column = moves.indexOf(ans-1);
            int row = moves.indexOf(ans-2);
            moves.remove(ans-1);
            moves.remove(ans-2);
            System.out.println(column);
            System.out.println(row);
            strArr [row][column] = "-";
            printBoard();
            return "last move undone";





        }
    }
}

