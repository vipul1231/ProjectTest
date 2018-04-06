package pckg.impl;

import java.util.List;

import pckg.constants.Constants;
import pckg.intf.IChess;

public class ChessImpl implements IChess{
	
	String[][] board;

	@Override
	public void formChessBoard(String[][] chessBoard) {

		//populate white
		int col = chessBoard[0].length;
		
		//populate first row	
		chessBoard[0][0] = Constants.whiteColor+Constants.ROOK;
		chessBoard[0][1] = Constants.whiteColor+Constants.HORSE;
		chessBoard[0][2] = Constants.whiteColor+Constants.BISHOP;
		chessBoard[0][3] = Constants.whiteColor+Constants.QUEEN;
		chessBoard[0][4] = Constants.whiteColor+Constants.KING;
		chessBoard[0][5] = Constants.whiteColor+Constants.BISHOP;
		chessBoard[0][6] = Constants.whiteColor+Constants.HORSE;
		chessBoard[0][7] = Constants.whiteColor+Constants.ROOK;
		//Populate second row
		int startRow = 1;
		
		for(int i=0;i<col;i++){
			chessBoard[startRow][i] = Constants.whiteColor+Constants.PAWN;
		}
		
		//Populate Other side
		chessBoard[7][0] = Constants.blackColor+Constants.ROOK;
		chessBoard[7][1] = Constants.blackColor+Constants.HORSE;
		chessBoard[7][2] = Constants.blackColor+Constants.BISHOP;
		chessBoard[7][3] = Constants.blackColor+Constants.QUEEN;
		chessBoard[7][4] = Constants.blackColor+Constants.KING;
		chessBoard[7][5] = Constants.blackColor+Constants.BISHOP;
		chessBoard[7][6] = Constants.blackColor+Constants.HORSE;
		chessBoard[7][7] = Constants.blackColor+Constants.ROOK;
		
		startRow = 6;
		for(int i=0;i<col;i++){
			chessBoard[startRow][i] = Constants.blackColor+Constants.PAWN;
		}
		
		//Assign  -- to blank column
		for(int i=2;i<6;i++){
			
			for(int j=0;j<col;j++){
				chessBoard[i][j] = "--";
			}
			
		}
		board = chessBoard;
	}

	@Override
	public boolean processMove(String input) {
		// TODO Auto-generated method stub
		String[] move = input.split(" ");
		String object = move[0];
		String[] rowCol = move[1].split("");
		String[] destRowCol = move[2].split("");
		int sRow = Integer.parseInt(rowCol[0]);
		int sCol = Integer.parseInt(rowCol[1]);

		int dRow = Integer.parseInt(destRowCol[0]);
		int dCol = Integer.parseInt(destRowCol[1]);

		// Check for Pawn
		if (object.equals("BP") || object.equals("WP")) {
			// fetch the object from board
			
			return processMovementForPawn(object, sRow, sCol, dRow, dCol);
		}
		
		//Check for Queen
		if (object.equals("WQ") || object.equals("BQ")) {
			return processMovementForQueen(object, sRow, sCol, dRow, dCol);
		}
		
		if (object.equals("BH") || object.equals("WH")) {
			return processMovementForHorse(object, sRow, sCol, dRow, dCol);
		}
		return false;
	}
	
	/**
	 * This method will prcess move for Pawn
	 * 
	 * @param object
	 * @param sRow
	 * @param sCol
	 * @param dRow
	 * @param dCol
	 * @return
	 */
	private boolean processMovementForPawn(String object, int sRow, int sCol,int dRow, int dCol){
		String obj = board[sRow][sCol];
		
		if (checkValidRowAndColumn(dRow, dCol) != null) {
			//Move straight.
			if (dCol == sCol) {
				if (dRow - sRow == 1 || dRow - sRow == -1) {
					board[sRow][sCol] = "--";
					board[dRow][dCol] = obj;
					return true;
				}
			}
			
			//Move Diagonal
			else if(((dCol == sCol - 1) && (dRow == sRow +1)) || ((dCol == sCol+1) && dRow == sRow + 1)){
				
				if(!board[dRow][dCol].equals("--")){
					board[sRow][sCol] = "--";
					board[dRow][dCol] = obj;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This method process moves for Queen
	 * 
	 * @param object
	 * @param sRow
	 * @param sCol
	 * @param dRow
	 * @param dColumn
	 * @return Valid Or Invalid (true/False)
	 */
	private boolean processMovementForQueen(String object, int sRow, int sCol,int dRow, int dColumn){
		
		if (checkValidRowAndColumn(dRow, dColumn) == null) {
			//If destination column and row is invalid return.
			return false;
		}
		
		//Check for straight move.
		if(sRow == dRow){
			for(int i=sCol+1;i<=dColumn;i++){
				
				if(board[sRow][i].equals("--")){
					continue;
				}
				else {
					
					if(i == dColumn && !board[dRow][i].equals("--")){
						//This means we have encountered a object at the end. So we can kill this object and replace it with queen.
						board[sRow][sCol] = "--";
						board[dRow][dColumn] = object;
						return true;
					}
					
					return false;
				}
				
			}
			
			//If we are reaching at this stage that mean we need to swap the postions of queen with destination
			board[sRow][sCol] = "--";
			board[dRow][dColumn] = object;
			return true;
		}
		else if(sCol == dColumn){
			for(int i=sRow+1;i<=dRow;i++){
				
				if(board[i][sCol].equals("--")){
					continue;
				}
				else {
					
					if(i == dRow && !board[i][dColumn].equals("--")){
						//This means we have encountered a object at the end. So we can kill this object and replace it with queen.
						board[sRow][sCol] = "--";
						board[dRow][dColumn] = object;
						return true;
					}
					else {
						
					}
					
					return false;
				}
				
			}
			board[sRow][sCol] = "--";
			board[dRow][dColumn] = object;
			return true;
		}
		
		
		//Now process queen diagonally
		
		//Moving Right bottom
		if(dColumn > sCol && dRow > sRow){
			
		}
		
		//Moving left 
		else if(dColumn < sCol && dRow > sRow){
			
		}
		return false;
	}
	
	
	
	private List<Integer> findTheCrossDiagonalMatrix(int dRow, int dCol){
		
		
		return null;
	}
	
	/**
	 * Process movement for horse
	 * 
	 * @param object
	 * @param sRow
	 * @param sCol
	 * @param dRow
	 * @param dColumn
	 * @return
	 */
	private boolean processMovementForHorse(String object, int sRow, int sCol,int dRow, int dColumn)
	{
		return false;
	}
	
	/**
	 * Check if the final move is valid or not.
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	private String checkValidRowAndColumn(int row, int column){
		String value;
		try{
			value = board[row][column];	
		}
		catch(Exception e) {
			return null;
		}
		
		return value;
	}

	@Override
	public void displayChessBoard() {
		// TODO Auto-generated method stub
		
		System.out.println("Display----");
		int row = this.board.length;
		int col = this.board.length;
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	

}
