package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;

	public ChessPosition(char column, int row) {
		// programacao defensiva
		// retorna erro ao indicar posicao fora do tabuleiro
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instanting ChessPosition. Valid values are from 01 to h8");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	// convserao da posicao do tabuleiro para a linha e coluna da matriz
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}

	// convserao inversa - da linha e coluna da matriz para a posicao do tabuleiro
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
	}
	@Override
	public String toString() {
		return "" + column + row;
	}
}
