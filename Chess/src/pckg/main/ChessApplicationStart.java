package pckg.main;

import java.util.Scanner;

import pckg.impl.ChessImpl;
import pckg.intf.IChess;

public class ChessApplicationStart {

	public static void main(String...strings){
		
		Scanner scanner = new Scanner(System.in);
		String[] grid = scanner.nextLine().split(" ");
		int row = Integer.parseInt(grid[0]);
		int col = Integer.parseInt(grid[1]);
		String[][] input = new String[row][col];
		IChess chess = new ChessImpl();
		chess.formChessBoard(input);
		chess.displayChessBoard();
		
		//Process Move
		int nooFMoves = Integer.parseInt(scanner.nextLine());
		
		for(int i=0;i<nooFMoves;i++){
			String move = scanner.nextLine();
			boolean valid = chess.processMove(move);
			if(valid){
				System.out.print("Move processed.."+move);
			}
			else {
				System.out.println("[ERROR]: Invalid Move!! :"+move);
			}
			chess.displayChessBoard();	
		}
		
		scanner.close();
		
	}
}
