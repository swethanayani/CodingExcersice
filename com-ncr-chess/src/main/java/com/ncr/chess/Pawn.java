package com.ncr.chess;

import java.util.Arrays;
import java.util.List;

public class Pawn {

	private ChessBoard chessBoard;
	private int xCoordinate;
	private int yCoordinate;
	private PieceColor pieceColor;

	public Pawn(PieceColor pieceColor) {
		this.pieceColor = pieceColor;
	}

	public ChessBoard getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}

	public int getXCoordinate() {
		return xCoordinate;
	}

	public void setXCoordinate(int value) {
		this.xCoordinate = value;
	}

	public int getYCoordinate() {
		return yCoordinate;
	}

	public void setYCoordinate(int value) {
		this.yCoordinate = value;
	}

	public PieceColor getPieceColor() {
		return this.pieceColor;
	}

	private void setPieceColor(PieceColor value) {
		pieceColor = value;
	}

	/**
	 * moves the piece to new coordinates
	 * 
	 * @param movementType
	 * @param newX
	 * @param newY
	 */
	public void move(MovementType movementType, int newX, int newY) {
		ChessBoard cb = new ChessBoard();
		List<Integer> possibleXCoordinates = Arrays.asList(this.getXCoordinate() + 1, this.getXCoordinate() - 1);
		List<Integer> possibleYCoordinates = Arrays.asList(this.getYCoordinate() + 1, this.getYCoordinate() - 1);
		if (cb.isLegalBoardPosition(newX, newY)
				&& (possibleXCoordinates.contains(newX) || possibleYCoordinates.contains(newY))) {
			this.setXCoordinate(newX);
			this.setYCoordinate(newY);
			System.out.println("moved piece to (" + this.getXCoordinate() + "," + this.getYCoordinate() + ")");
		} else {
			System.out.println("Cannot moved piece to (" + newX + "," + newY + ")");
		}
	}

	@Override
	public String toString() {
		return getCurrentPositionAsString();
	}

	protected String getCurrentPositionAsString() {
		String eol = System.lineSeparator();
		return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate,
				pieceColor);
	}
}
