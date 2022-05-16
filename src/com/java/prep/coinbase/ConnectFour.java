package com.java.prep.coinbase;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConnectFour {

	public static void main(String[] args) {
		Player[] players = { new Player("A", PlayerColor.RED), new Player("B", PlayerColor.YELLOW) };
		try (Scanner input = new Scanner(System.in)) {
			GamePlay gamePlay = new GamePlay(7, 6);
			int moves = 7 * 6;
			for (int player = 0; moves-- > 0; player = 1 - player) {
				System.out.println("-------------------- Player : " + (player + 1)
						+ " Turn. Please Select Column For Next Move! --------------------");
				int colToPlay = input.nextInt();
				MoveStatus moveStatus = gamePlay.play(colToPlay, players[player]);
				if (moveStatus == MoveStatus.PLAYER_WON) {
					System.out.println("Player - " + player + " Won!");
					break;
				} else if (moveStatus == MoveStatus.NO_MOVES) {
					System.out.println("No Further Moves Left! Game Drawn");
					break;
				} else if (moveStatus == MoveStatus.INVALID) {
					do {
						System.out.println("Invalid Move! Please Try Again! ----------------");
						colToPlay = input.nextInt();
						moveStatus = gamePlay.play(colToPlay, players[player]);
						if (moveStatus == MoveStatus.PLAYER_WON) {
							System.out.println("Player - " + player + " Won!");
							break;
						} else if (moveStatus == MoveStatus.NO_MOVES) {
							System.out.println("No Further Moves Left! Game Drawn");
							break;
						}
					} while (moveStatus == MoveStatus.INVALID);
				} else if (moveStatus == MoveStatus.SUCCESS) {
					System.out.println("Player - " + player + " Chance Successful");
				} else {
					System.out.println("Invalid Status");
					break;
				}
				System.out.println("-------------------- Player Turn Finished! --------------------");
			}
		}
	}

}

class GamePlay {

	private GamePlayOperations gamePlayOperations;
	private Board board;

	public GamePlay(int boardWidth, int boardHeight) {
		this.board = new Board(boardWidth, boardHeight);
		this.gamePlayOperations = new GamePlayOperations(board);
	}

	/**
	 * This method allows player to play if there are further possible moves.
	 * 
	 * @param column
	 * @param player
	 * @return
	 */
	public MoveStatus play(int column, Player player) {
		if (GamePlayChecks.isMoveLeft(board)) {
			System.out.println("Moves Left! Moving Ahead!");
			Move move = gamePlayOperations.move(column, player);
			System.out.println("Board After Current Turn - \n" + board);
			if (move == null) {
				System.out.println("Invalid Move");
				return MoveStatus.INVALID;
			}
			board.decrementMoves();
			System.out.println("Player Move Valid! Decremented Possible Moves! Checking For Player Win");
			if (GamePlayChecks.isPlayerWinning(move, board)) {
				System.out.println("Player - " + player + " Won!");
				return MoveStatus.PLAYER_WON;
			}
			System.out.println("No Wins Yet! Proceed With Next Turn");
			return MoveStatus.SUCCESS;
		}
		return MoveStatus.NO_MOVES;
	}

}

class GamePlayOperations {

	private Board board;

	public GamePlayOperations(Board board) {
		this.board = board;
	}

	/**
	 * This method performs the player move for a given column.
	 * 
	 * @param column
	 * @param player
	 * @return
	 */
	public Move move(int column, Player player) {
		Move move = new Move(column, player.getPlayerColor());
		if (GamePlayChecks.isValidMove(move, board)) {
			System.out.println("Player Move Valid! Proceeding To Find The Available In The Grid!");
			findRowPositionInBoardForPlayerMove(column, player, move);
			System.out.println("Player Move Successful! " + move);
			return move;
		}
		return null;
	}

	/**
	 * This method finds the available row for a player move for a gicven column.
	 * 
	 * @param column
	 * @param player
	 * @param move
	 */
	private void findRowPositionInBoardForPlayerMove(int column, Player player, Move move) {
		for (int index = board.getBoardHeight() - 1; index >= 0; index--) {
			if (board.getBoard()[index][move.getColumn()] == PlayerColor.NONE) {
				board.getBoard()[index][move.getColumn()] = move.getPlayerColor();
				move.setRow(index);
				break;
			}
		}
	}

}

class GamePlayChecks {

	/**
	 * This method checks if the player with last move is winning the game or not.
	 * 
	 * @param move
	 * @param board
	 * @return
	 */
	public static boolean isPlayerWinning(Move move, Board board) {
		System.out.println("Checking Player Win For Move - " + move);
		if (PlayerColor.NONE == move.getPlayerColor()) {
			return false;
		}
		PlayerColor lastMoveColor = move.getPlayerColor();
		return BoardUtils.checkColorStreak(lastMoveColor, BoardUtils.getHorizontalStrip(move, board))
				|| BoardUtils.checkColorStreak(lastMoveColor, BoardUtils.getVerticalStrip(move, board))
				|| BoardUtils.checkColorStreak(lastMoveColor, BoardUtils.getForwardDiagonal(move, board))
				|| BoardUtils.checkColorStreak(lastMoveColor, BoardUtils.getBackwardDiagonal(move, board));
	}

	/**
	 * This method checks if the player move is valid or not.
	 * 
	 * @param move
	 * @param board
	 * @return
	 */
	public static boolean isValidMove(Move move, Board board) {
		return checkIfColumnSelectedIsValid(move, board) && checkIfColumnSpaceIsAvailable(move, board);

	}

	/**
	 * This method checks if column selected is valid.
	 * 
	 * @param move
	 * @param board
	 * @return
	 */
	private static boolean checkIfColumnSelectedIsValid(Move move, Board board) {
		return move.getColumn() >= 0 && move.getColumn() < board.getBoardWidth();
	}

	/**
	 * This method checks whether there is valid cell available in the column.
	 * 
	 * @param move
	 * @param board
	 * @return
	 */
	private static boolean checkIfColumnSpaceIsAvailable(Move move, Board board) {
		return board.getBoard()[0][move.getColumn()] == PlayerColor.NONE;
	}

	/**
	 * This method checks if any further move is possible.
	 * 
	 * @param board
	 * @return
	 */
	public static boolean isMoveLeft(Board board) {
		return board.getPossibleMoves() > 0;
	}

}

class BoardUtils {

	/**
	 * This method returns the row of the board based on the last move by a player.
	 * 
	 * @param move
	 * @param board
	 * @return
	 */
	public static PlayerColor[] getHorizontalStrip(Move move, Board board) {
		System.out.println("Getting Horizontal Strip For Move - " + move);
		return board.getBoard()[move.getRow()];
	}

	/**
	 * This method returns the column of the board based on the last move by a
	 * player.
	 * 
	 * @param move
	 * @param board
	 * @return
	 */
	public static PlayerColor[] getVerticalStrip(Move move, Board board) {
		System.out.println("Getting Vertical Strip For Move - " + move);
		PlayerColor[] boardColumn = new PlayerColor[board.getBoardHeight()];
		for (int index = 0; index < board.getBoardHeight(); index++) {
			boardColumn[index] = board.getBoard()[index][move.getColumn()];
		}
		return boardColumn;
	}

	/**
	 * This method returns the forward diagonal of the board based on the last move
	 * by a player.
	 * 
	 * @param move
	 * @param board
	 * @return
	 */
	public static PlayerColor[] getForwardDiagonal(Move move, Board board) {
		System.out.println("Getting Forward Diagonal Strip For Move - " + move);
		PlayerColor[] forwardDiagonal = new PlayerColor[board.getBoardHeight()];
		for (int index = 0; index < board.getBoardHeight(); index++) {
			int row = move.getColumn() + move.getRow() - index;
			if (row >= 0 && row < board.getBoardWidth()) {
				forwardDiagonal[index] = board.getBoard()[index][row];
			}
		}
		return forwardDiagonal;
	}

	/**
	 * This method returns the backward diagonal of the board based on the last move
	 * by a player.
	 * 
	 * @param move
	 * @param board
	 * @return
	 */
	public static PlayerColor[] getBackwardDiagonal(Move move, Board board) {
		System.out.println("Getting Backward Diagonal Strip For Move - " + move);
		PlayerColor[] forwardDiagonal = new PlayerColor[board.getBoardHeight()];
		for (int index = 0; index < board.getBoardHeight(); index++) {
			int row = move.getColumn() - move.getRow() + index;
			if (row >= 0 && row < board.getBoardWidth()) {
				forwardDiagonal[index] = board.getBoard()[index][row];
			}
		}
		return forwardDiagonal;
	}

	/**
	 * This method returns the formatted streak required for a player with color to
	 * win.
	 * 
	 * @param color
	 * @return
	 */
	private static String getStreak(String color) {
		return String.format(ConnectFourConstants.STREAK_FORMAT, color, color, color, color);
	}

	/**
	 * This method converts the strip to check to string.
	 * 
	 * @param strip
	 * @return
	 */
	private static String convertStripToString(PlayerColor[] strip) {
		return Arrays.stream(strip).filter(color -> color != null).map(color -> color.getColor())
				.collect(Collectors.joining(""));
	}

	/**
	 * This method checks for color streak.
	 * 
	 * @param lastMoveColor
	 * @param strip
	 * @return
	 */
	public static boolean checkColorStreak(PlayerColor lastMoveColor, PlayerColor[] strip) {
		String boardStrip = convertStripToString(strip);
		String streak = getStreak(lastMoveColor.getColor());
		return boardStrip.indexOf(streak) >= 0;
	}

}

/**
 * Class representing the connect four board.
 */
class Board {

	private int boardWidth;
	private int boardHeight;
	private int possibleMoves;
	private PlayerColor[][] board;

	public Board(int boardWidth, int boardHeight) {
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		this.board = new PlayerColor[this.boardHeight][this.boardWidth];
		this.possibleMoves = boardWidth * boardHeight;
		this.createBoard();
		this.toString();
	}

	public PlayerColor[][] getBoard() {
		return board;
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}

	public int getPossibleMoves() {
		return possibleMoves;
	}

	/**
	 * This method creates the board for game play.
	 */
	private void createBoard() {
		for (int index = 0; index < boardHeight; index++) {
			Arrays.fill(board[index], PlayerColor.NONE);
		}
	}

	/**
	 * This method decrement the possible moves.
	 */
	public void decrementMoves() {
		this.possibleMoves--;
	}

	@Override
	public String toString() {
		StringBuilder gridView = new StringBuilder();
		for (int row = 0; row < boardHeight; row++) {
			for (int column = 0; column < boardWidth; column++) {
				gridView.append(board[row][column].getColor());
			}
			gridView.append("\n");
		}
		return gridView.toString();
	}

}

/**
 * Class representing the player.
 */
class Player {

	private String playerName;
	private PlayerColor playerColor;

	public Player(String playerName, PlayerColor playerColor) {
		this.playerName = playerName;
		this.playerColor = playerColor;
	}

	public String getPlayerName() {
		return playerName;
	}

	public PlayerColor getPlayerColor() {
		return playerColor;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", playerColor=" + playerColor + "]";
	}

}

/**
 * Enum defining possible colors for a grid cell in the game.
 */
enum PlayerColor {
	RED("R"), YELLOW("Y"), NONE(".");

	private String color;

	PlayerColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

}

/**
 * Class denoting the next move by a player.
 */
class Move {

	private int row = -1;
	private int column = -1;
	private PlayerColor playerColor = PlayerColor.NONE;

	public Move(int column, PlayerColor playerColor) {
		this.column = column;
		this.playerColor = playerColor;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public PlayerColor getPlayerColor() {
		return playerColor;
	}

	@Override
	public String toString() {
		return "Move [row=" + row + ", column=" + column + ", playerColor=" + playerColor + "]";
	}

}

enum MoveStatus {
	SUCCESS, NO_MOVES, INVALID, PLAYER_WON
}

class ConnectFourConstants {

	public static final String STREAK_FORMAT = "%s%s%s%s";
}
