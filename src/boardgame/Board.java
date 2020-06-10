package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		// programação defensiva,
		// testa se existe pelo menos 1 coluna e 1 linha
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erros creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		// Programação defensiva.
		// Testa se foi lançada uma posição fora do tabuleiro
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		// Programação defensiva.
		// Testa se foi lançada uma posição fora do tabuleiro
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		// verificar se já há peça na posicao informada
		if (thereIsAPiece(position)) {
			throw new BoardException("there is already a piece on position" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	// testar se uma posicao existe
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	// testa se existe uma peca
	public boolean thereIsAPiece(Position position) {
		// Testa se a posicao existe no tabuleiro
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}

}
