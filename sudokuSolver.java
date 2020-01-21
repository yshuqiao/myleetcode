package myleetcode;
//力扣题37，解数独，可用回溯法
public class sudokuSolver
{

	//box size
	int n = 3;
	//row size
	int N = n*n;
	
	int [][] rows =new int[N][N+1];
	int [][] columns = new int[N][N+1];
	int [][] boxes = new int[N][N+1];
	
	char[][] board;
	
	boolean sudokuSolved = false;
	
	public boolean couldPlace(int d,int row,int col) {
		/*
		 Check if one could place a number d in (row,col) cell
		*/
		int idx = (row/n)*n+col/n;
		return rows[row][d] +columns[col][d] + boxes[idx][d] == 0;
	}
	
	public void placeNumber(int d,int row,int col) {
		/*
		 * Place a number d in (row,col) cell
		 */
		int idx = (row/n)*n +col/n;
		
		rows[row][d]++;
		columns[col][d]++;
		boxes[idx][d]++;
		board[row][col] = (char)(d+'0'); 
	}
	
	public void removeNumber(int d,int row,int col) {
		/*
		 * Remove a number which didn't lead to a solution
		 */
		int idx = (row/n)*n + col/n;
		rows[row][d]--;
		columns[col][d]--;
		boxes[idx][d]--;
		board[row][col] = '.';
	}
	
	public void placeNextNumbers(int row,int col) {
		/*
		 * Call backtrack function in recursion
		 * to continue to place numbers
		 * till the moment we have a solution
		 */
		//if we're in the last cell
		//that means we have the solution
		if ((col == N-1)&&(row == N-1)) {
			sudokuSolved = true;
		}
		//if not yet
		else {
			//if we're in the end of the row
			//go to the next row
			if(col == N-1) backtrack(row+1,0);
			//go to the next column
			else backtrack(row,col+1);
		}
	}
	
	public void backtrack(int row,int col) {
		/*
		 * Backtracking
		 */
		//if the cell is empty
		if (board[row][col] == '.') {
			//iterate over all numbers from 1 to 9
			for (int d=1;d<10;d++) {
				if (couldPlace(d,row,col)) {
					placeNumber(d,row,col);
					placeNextNumbers(row,col);
					//if sudoku is solved,there is no need to backtrack
					//since the single unique solution is promised
					if(!sudokuSolved) removeNumber(d,row,col);
				}
			}
		}
		else placeNextNumbers(row,col);
	}
	
	public void solveSudoku(char[][] board) {
		this.board = board;
		
		//init rows,columns and boxes
		for (int i = 0;i<N;i++) {
			for(int j=0;j<N;j++) {
				char num = board[i][j];
				if (num != '.') {
					int d = Character.getNumericValue(num);
					placeNumber(d,i,j);
				}
			}
		}
		backtrack(0,0);
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		sudokuSolver sudoSolve = new sudokuSolver();
		
		char[][] board = new char[9][9];
		for(int i = 0;i<=8;i++) {
			for(int j = 0;j<=8;j++) {
				board[i][j]='.';
			}
		}
		board[0][0]='5';board[0][1]='3';board[0][4]='7';
		board[1][0]='6';board[1][3]='1';board[1][4]='9';board[1][5]='5';
		board[2][1]='9';board[2][2]='8';board[2][7]='6';
		board[3][0]='8';board[3][4]='6';board[3][8]='3';
		board[4][0]='4';board[4][3]='8';board[4][5]='3';board[4][8]='1';
		board[5][0]='7';board[5][4]='2';board[5][8]='6';
		board[6][1]='6';board[6][6]='2';board[6][7]='8';
		board[7][3]='4';board[7][4]='1';board[7][5]='9';board[7][8]='5';
		board[8][4]='8';board[8][7]='7';board[8][8]='9';
		
		sudoSolve.solveSudoku(board);
		
		for(int i = 0;i<=8;i++) {
			System.out.println("第"+i+"行");
			for(int j = 0;j<=8;j++) {
				System.out.print(board[i][j]);
			}
		}

	}

}
