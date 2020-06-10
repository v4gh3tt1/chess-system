package application;

import boardgame.Board;
import chess.ChessMatch;

@SuppressWarnings("unused")
public class Program {

	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());
	}

}
