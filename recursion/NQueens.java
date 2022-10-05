class NQueens {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        nqueens(board,0,ans);
        return ans;
    }
    
    void nqueens(boolean[][] board, int row,List<List<String>> ans){
      // It means we have reached the last row and this solution is valid, (for counting no. of distinct solutions just return 1 (the function will be of type int))
        if(row == board.length){
            List<String> p = new ArrayList<>();
            String str = "";
            for(boolean[] nums : board){
               for(boolean element : nums){
                  if(element){
                    str += "Q";
                  }
                   else{
                    str += ".";
                  }
               }
                p.add(str);
                str = "";
            }
            ans.add(new ArrayList(p));
        }
        
        // placing the queen and checking for every row and col
        for (int col = 0; col < board.length; col++) {
            // place the queen if it is safe
            if(isSafe(board, row, col)){
                board[row][col] = true;
                nqueens(board, row + 1, ans); // for counting create a count variable and increment it with the nqueens function
                board[row][col] = false;
            }
        }
    }
    
    boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical row
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        // diagonal left check
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft ; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }

        // diagonal right check
        int maxRight = Math.min(row,board.length - col -1);
        for (int i = 0; i <= maxRight; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }
}
