import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {
    public  boolean isValid(char[][] sudokuBox){

        Set<Character> rowset = new HashSet<>();
        Set<Character> colSer = new HashSet<>();

        for(int i=0;i<9;i++){
            rowset = new HashSet<>();
            colSer = new HashSet<>();

            for(int j=0;j<9;j++){
                char r = sudokuBox[i][j];
                char c = sudokuBox[j][i];

                if(rowset.contains(r)){
                    return false;

                } else if (colSer.contains(c)) {
                    return false;

                }

                if(r == '.'){
                    continue;
                }else{
                    rowset.add(r);
                }
                if(c == '.'){
                    continue;
                }else{
                    colSer.add(c);
                }
            }


        }
        // checking blocks
        for(int i=0;i<9;i+=3){
            for (int j=0;j<9;j+=3){
                if(!checkBlock(i,j,sudokuBox)){
                    return false;
                }


            }
        }
        return true;
    }

    public boolean checkBlock(int idxI, int idxJ, char[][] board){

        int row = idxI + 3;
        int col = idxJ + 3;
        List<Character> prev = new ArrayList<>();
        for(int i=idxI;i<row;i++){
            for(int j=idxJ;j<col;j++){

                if(board[i][j] == '.'){
                    continue;
                }
                char c = board[i][j];
                if(prev.contains(c)){
                    return false;
                }

                prev.add(c);

            }
        }
        return true;
    }

    public static void main(String[] args){
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        ValidSudoku validSudoku = new ValidSudoku();

        System.out.println(validSudoku.isValid(board));

    }













}
