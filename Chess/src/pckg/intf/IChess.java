package pckg.intf;

public interface IChess {
	
	/**
	 * Make a Chess board for game play
	 * 
	 * @param board
	 */
	void formChessBoard(String[][] board);
	
	/**
	 * Process the moves provided.
	 * 
	 * @param input
	 * @return
	 */
	boolean processMove(String input);

	/**
	 * Display current state of chess board.
	 * 
	 */
	void displayChessBoard();
}
