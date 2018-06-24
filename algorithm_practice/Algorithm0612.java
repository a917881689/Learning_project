package algorithm;

/**
 * 解数独
 * @Author: yoSakura
 * @Date: 2018/6/12 12:33
 */
public class Algorithm0612 {
    public static void main(String[] args) {
        Solution0612 s = new Solution0612();
        char[] [] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        s.solveSudoku(board);
        for (char[] c : board) {
            for (char a :c) {
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
class Solution0612 {
    private int count = 0;
    public void solveSudoku(char[][] board) {
        this.solve(board,0,0);
        System.out.println(count);
    }
    public boolean solve (char[][] board,int i,int j) {

        if (i==9) {
            return true;
        }
        if (j == 9){
            return solve(board,i+1,0);
        }

        if (board[i][j] == '.') {

            for (char n = '1' ;n <= '9' ;n++) {
                count++;
                if (isValid(board,i,j,n)) {
                    board[i][j] = n;
                    if (solve(board,i,j+1)) {
                        return true;
                    }else {
                        board[i][j] = '.';
                    }
                }
            }
            return false;
        }
        return solve(board,i,j+1);

//        for (int i = 0 ;i < 9 ;i++) {
//            for (int j = 0 ;j < 9 ;j++) {
//
//                if(i==9 && j==9) { return true;}
//                if (board[i][j] == '.') {
//                    for(char c = '1'; c<='9';c++){
//                        count++;
//                        if(isValid(board,i,j,c)) {
//                            board[i][j] = c;
//                            System.out.println("--");
//                            if (solve(board)) {
//                                return true;
//                            }else {
//                                board[i][j]='.';
//                            }
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;
    }
    private static boolean isValid(char[][] board, int row, int column, char c) {
        for (int i = 0;i < 9 ;i++) {
            if (board[row/3*3+i/3][column/3*3+i%3] == c) { return false;}
            if (board[row][i] == c) { return false; }
            if (board[i][column] == c) { return false; }
        }
        return true;
    }
}

