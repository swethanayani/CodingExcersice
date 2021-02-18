package com.ncr.chess;

public class ChessBoard {

	public static int MAX_BOARD_WIDTH = 7;
	public static int MAX_BOARD_HEIGHT = 7;

	public Pawn[][] pieces;

	public ChessBoard() {
		pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
	}

	/**
	 * Adds piece to the chessboard when positions are legal
	 * 
	 * @param pawn
	 * @param xCoordinate
	 * @param yCoordinate 
	 * @param pieceColor
	 */
	public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
		if (isLegalBoardPosition(xCoordinate, yCoordinate) && pieces[xCoordinate][yCoordinate] == null) {
			pawn.setXCoordinate(xCoordinate);
			pawn.setYCoordinate(yCoordinate);
			pieces[xCoordinate][yCoordinate] = pawn;
			System.out.println("Inserted piece at x:" + pawn.getXCoordinate() + " and y:" + pawn.getYCoordinate());
		} else {
			System.out.println("Cannot Inserted piece at x:" + xCoordinate + " and y:" + yCoordinate);
			pawn.setXCoordinate(-1);
			pawn.setYCoordinate(-1);
		}
	}

	/**
	 * this method checks if the position is legal as per length of chessboard
	 * defined
	 * 
	 * @param xCoordinate
	 * @param yCoordinate
	 * @return
	 */
	public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
		if ((xCoordinate >= 0 && xCoordinate < MAX_BOARD_WIDTH)
				&& (yCoordinate >= 0 && yCoordinate < MAX_BOARD_HEIGHT)) {
			System.out.println("Legal board position to insert piece");
			return true;
		} else {
			System.out.println("Not legal board position to insert piece");
			return false;
		}
	}
}
