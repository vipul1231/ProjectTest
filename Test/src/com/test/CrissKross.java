package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CrissKross {
	
	List<Tile> boardList = null;
	
	public List<Tile> getBoardList() {
		return boardList;
	}

	public void setBoardList(int size) {
		Tile tile = null;
		boardList = IntStream.range(0, size).mapToObj(i -> tile).collect(Collectors.toList());
		
	}

	class Tile {
		private String value;
		private final int row;
		private final int column;
		private final int listIndex;

		Tile(int row, int column, String value, int index){
			this.row = row;
			this.column = column;
			this.value = value;
			this.listIndex = index;
		}
		
		public int getListIndex() {
			return listIndex;
		}	
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
	}

	
	/**
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	private Tile[][] createBoard(int row, int column){
		
		Tile[][] array = new Tile[row][column];
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				int index = j * row + i;
				Tile tile = new Tile(i, j, "--", index);
				array[i][j] = tile;
				boardList.set(index, tile);
			}
		}
		return array;
	}
	
	/**
	 * 
	 * @param board
	 */
	private void displayBoard(Tile[][] board){
		
		int row = board[0].length;
		int col = board.length;
		 
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(board[i][j].getValue()+" ");
			}
			System.out.println("");
		}
	}
	
	/**
	 * This method process your move
	 * 
	 * @param number
	 */
	private boolean processMove(int number, String symbol, int noOfRows, Tile[][] board){
		
		//Process the move on ArrayList
		Tile tile = boardList.get(number);
		tile.setValue(symbol);
	
		//Check horizontal
		boolean result = check(0, 3, 1, noOfRows,0);
		
		//Check vertical
		result = check(0, 1, 3, noOfRows,0);
		
		//Check diagonal
		result = check(0, 4, 2, noOfRows,0);
		
		//Display the board
		displayBoard(board);
		
		if(result){
			return true;
		}
		
		return false;

	}
	
	/**
	 * 
	 * 
	 * @param start
	 * @param horizontalIncrement
	 * @param verticalIncrement
	 * @param noOfRows
	 * @return
	 */
	private boolean check(int start, int horizontalIncrement, int verticalIncrement, int totalRows, int processedRow){
		
		int first = start;
		int count  = 0;
		Tile previousTile = null;
		boolean allSame = false;
		
		if(processedRow == totalRows){
			return false;
		}
		
		while(count != totalRows){
			
			Tile tile = boardList.get(first);
			if(previousTile==null){
				previousTile = tile;	
			}
			else {
				if(previousTile.getValue().equals(tile.getValue()) && !previousTile.getValue().equals("--")){
					allSame = true;
					previousTile = tile;
					continue;
				}
				else {
					allSame = false;
					break;
				}
			}
			first = first + horizontalIncrement;
			count++;
		}
		
		if(allSame){
			return true;
		}
		else {
			check(start+verticalIncrement, horizontalIncrement,verticalIncrement, totalRows, processedRow+1);
		}
		
		return allSame;
		
	}
	
	public static void main(String[] args){
		Map<String,String> playerMap = new HashMap<>();
		
		CrissKross crissKross = new CrissKross();
		System.out.println("##### Welcome to Criss Kroxx Game #####");
		Scanner scanner = new Scanner(System.in);
		int size = Integer.parseInt(scanner.nextLine());
		crissKross.setBoardList(size*size);
		Tile[][] board = crissKross.createBoard(size, size);
		crissKross.displayBoard(board);
		
		
		String player1, player2;
		System.out.println("Enter Player 1 name: ");
		player1 = scanner.nextLine();
		System.out.println("Enter Player 2 name: ");
		player2 = scanner.nextLine();
		playerMap.put(player1, "O");
		playerMap.put(player2, "X");
		
		
		boolean moveSwitch= false;
		while(true){
			
			boolean player1Wins = false, player2Wins = false;
			if(moveSwitch){
				int move  = scanner.nextInt();
				player1Wins = crissKross.processMove(move, playerMap.get(player1), board.length, board);	
				moveSwitch = false;
			}
			else {
				int move  = scanner.nextInt();
				player2Wins = crissKross.processMove(move, playerMap.get(player2), board.length, board);
				moveSwitch = true;
			}
			
			if(player1Wins || player2Wins){
				System.out.println("Some one wins");
				break;
			}
		}
	
		scanner.close();
	}
}
